package com.teddy.dao;

import com.teddy.entity.Support;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupportDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Support.class, id);
    }

    public List<Support> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Support> query = session.createQuery("from Support as s where s.name = ?1", Support.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Support support) {
        sessionFactory.getCurrentSession().save(support);
    }

    public void saveOrUpdate(Support support) {
        sessionFactory.getCurrentSession().saveOrUpdate(support);
    }

    public void update(Support support) {
        sessionFactory.getCurrentSession().update(support);
    }
}
