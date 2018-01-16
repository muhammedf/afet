package muhammedf.afet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

    @PersistenceContext(unitName = "afet-persistence-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    protected Class<T> claz;

    public GenericDAOImpl(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.claz = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        entityManager.remove(t);
    }

    @Override
    public T read(PK id) {
        return entityManager.find(claz, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("select * from "+claz.getSimpleName()).getResultList();
    }
}
