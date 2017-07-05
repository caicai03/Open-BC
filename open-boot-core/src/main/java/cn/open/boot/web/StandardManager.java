package cn.open.boot.web;

/**
 * @param <T>
 * @param <K>
 */
public abstract class StandardManager<T, K> {

    public abstract void delete(K id);

    public abstract void create(T t);

    public abstract void update(T t);

    public abstract T get(K id);

}
