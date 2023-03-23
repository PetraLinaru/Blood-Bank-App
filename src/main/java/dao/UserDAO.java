package dao;

import org.hibernate.annotations.Parameter;
import org.hibernate.query.*;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractHibernateDao<User> {
    SessionFactory sessionFactory;
    private List<User> users = new ArrayList<>();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findOne(String username) { //partea asta a functionat pana azi noapte, am modificat ddlauto=create-drop si apoi
                                            // si apoi am modificat-o la loc in ddlauto=update si nu a mai functionat
        //sad face
        Session session = this.sessionFactory.openSession();


        Query query=session.createQuery("Select user from User user where user.username=:usernameParam");
        query.setParameter("usernameParam", username);
        User returned= (User) query.setMaxResults(1).getSingleResult(); //aici crapa de aseara
        session.close();
        return returned;
    }

    @Override
    public List<User> findAll() {
        Session session = this.sessionFactory.openSession();
        List<User> users=session.createQuery("from User ").list();
        return users;
    }


    public User create(User entity)
    {

        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }
    @Override
    public User update(User entity) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.close();
        return entity;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteByCustomizedParameter(Object o) {

    }
}
