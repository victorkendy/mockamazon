package br.com.harada.mockamazon.infra;

import net.vidageek.mirror.dsl.Mirror;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by victor on 29/09/2016.
 */
@Component
public class AwsParameterParser {
    public <T> T parse(Class<T> clazz, Map<String, String[]> params){
        try {
            T value = clazz.newInstance();
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                String paramName = entry.getKey();
                String paramRawValue = entry.getValue()[0];
                setValue(value, paramName.split("\\."), 0, paramRawValue);
            }
            return value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void setValue(T object, String[] path, int pathIndex, String paramValue) throws Exception {
        if(pathIndex < path.length - 1) {
            Method getter = object.getClass().getMethod("get" + path[pathIndex]);
            Object fieldValue = getter.invoke(object);
            if(fieldValue == null) {
                fieldValue = getter.getReturnType().newInstance();
                Method fieldSetter = object.getClass().getMethod("set" + path[pathIndex], getter.getReturnType());
                fieldSetter.invoke(object, fieldValue);
            }
            if(fieldValue instanceof List) {
                String fieldName = Character.toLowerCase(path[pathIndex].charAt(0)) + path[pathIndex].substring(1);
                ParameterizedType genericType = (ParameterizedType) object.getClass().getDeclaredField(fieldName).getGenericType();
                Type[] genericTypeArguments = genericType.getActualTypeArguments();

                setListValue((List)fieldValue, (Class)genericTypeArguments[0], path, pathIndex + 1, paramValue);
            } else {
                setValue(fieldValue, path, pathIndex + 1, paramValue);
            }
        } else {
            Method setter = null;
            String setterName = "set" + path[path.length - 1];
            for (Method m : object.getClass().getDeclaredMethods()) {
                if (m.getName().equals(setterName)) {
                    setter = m;
                    break;
                }
            }
            if (setter == null) {
                return;
            }
            Class<?>[] setterParams = setter.getParameterTypes();
            if (setterParams.length != 1) {
                throw new RuntimeException("Wrong number of arguments for setter");
            }
            ParameterConverter converter = ParameterConverter.converterFor(setterParams[0]);
            setter.invoke(object, converter.convert(paramValue));
        }
    }

    private void setListValue(List list, Class<?> listType, String[] path, int pathIndex, String paramValue) throws Exception {
        Integer listIndex = Integer.parseInt(path[pathIndex]) - 1;
        Object listItemValue = listType.newInstance();
        if(list.size() <= listIndex) {
            list.add(listIndex, listItemValue);
        }
        Object actualListItem = list.get(listIndex);
        if(actualListItem == null) {
            actualListItem = listItemValue;
            list.add(listIndex, listItemValue);
        }
        setValue(actualListItem, path, pathIndex + 1, paramValue);
    }
}

