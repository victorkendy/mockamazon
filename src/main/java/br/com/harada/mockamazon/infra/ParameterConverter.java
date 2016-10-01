package br.com.harada.mockamazon.infra;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by victor on 29/09/2016.
 */
public enum ParameterConverter {

    BIG_INTEGER_CONVERTER(BigInteger.class){
        @Override
        public Object convert(String value) {
            return new BigInteger(value);
        }
    },
    STRING_CONVERTER(String.class) {
        @Override
        public Object convert(String value) {
            return value;
        }
    },
    ;


    static Map<Class<?>, ParameterConverter> converters = new ConcurrentHashMap<>();
    static{
        for (ParameterConverter converter : values()) {
            converters.put(converter.type, converter);
        }
    }

    private final Class<?> type;

    private ParameterConverter(Class<?> type) {
        this.type = type;
    }
    public abstract Object convert(String value);

    public static ParameterConverter converterFor(Class<?> clazz){
        return converters.get(clazz);
    }
}
