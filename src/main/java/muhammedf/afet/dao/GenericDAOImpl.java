package muhammedf.afet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

public abstract class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {

    @PersistenceContext(unitName = "afet-persistence-unit", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    abstract protected Class<T> claz();

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
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

    @Override
    public T read(PK id) {
        return entityManager.find(claz(), id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("select t from "+claz().getSimpleName()+" t").getResultList();
    }
}
