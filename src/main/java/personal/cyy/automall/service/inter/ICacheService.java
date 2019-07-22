package personal.cyy.automall.service.inter;

/**
 * @Author Cinyky
 * @Date 15:27 2019-07-13
 */
public interface ICacheService<T> {

    T putIntoCache(T t);

    T getFromCache(String id);

    T removeFromCache(String id);
}
