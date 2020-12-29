package DAO;

import models.Security;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


public class DAO {
    public Security findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Security security = session.get(Security.class, id);
        session.close();
        return security;
    }

    public void saveOrUpdate(Security security) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(security);
        tx1.commit();
        session.close();
    }

    public void update(Security security) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(security);
        tx1.commit();
        session.close();
    }

    public void delete(Security security) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(security);
        tx1.commit();
        session.close();
    }

    //удаляет список акций
    public void delete(List<Security> list) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (Security security: list ) {
            session.delete(security);
        }
        tx1.commit();
        session.close();
    }

    public List <Security>findAll() {
        List <Security> list;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        list = (List <Security>)session.createQuery("From Security").list();
        tx1.commit();
        session.close();
        return list;
    }
}
