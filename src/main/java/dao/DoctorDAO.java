package dao;

import jakarta.persistence.Query;
import model.Doctor;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
//am incercat sa fac operatiile pentru doctor
public class DoctorDAO implements AbstractHibernateDao<Doctor> {
    SessionFactory sessionFactory;
    private List<User> users = new ArrayList<>();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Doctor findOne(String username) {
        Session session = this.sessionFactory.openSession();
        Query query=session.createQuery("from Doctor where username=username ");
        Doctor returned=(Doctor) query.setMaxResults(1).getSingleResult();
        session.close();
        return returned;
    }

    @Override
    public List<Doctor> findAll() {
        Session session = this.sessionFactory.openSession();
        List<Doctor> doctors=session.createQuery("from Doctor ").list();
        return doctors;
    }

    @Override
    public Doctor create(Doctor entity) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public Doctor update(Doctor entity) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(Doctor entity) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteByCustomizedParameter(Object o) {
        final Doctor entity = findOne((String) o);
        delete(entity);
    }
}
