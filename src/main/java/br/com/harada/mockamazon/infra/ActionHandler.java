package br.com.harada.mockamazon.infra;

/**
 * Created by victor on 01/10/2016.
 */
public interface ActionHandler<R,T> {
    R handle (T param);
}
