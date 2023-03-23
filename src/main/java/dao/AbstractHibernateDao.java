package dao;

import hibernatestuff.HibernateUtils;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface AbstractHibernateDao<T>{


    public T findOne(String username);

    public List<T> findAll();

    public T create(final T entity);

    public T update(final T entity);

    public void delete(final T entity);

    public void deleteByCustomizedParameter(Object o);

}
