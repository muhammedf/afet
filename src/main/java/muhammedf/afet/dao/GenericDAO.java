package muhammedf.afet.dao;

import java.util.List;

public interface GenericDAO<T, PK> {

    T create(T t);
    T update(T t);
    void delete(T t);
    T read(PK id);
    List<T> findAll();

}