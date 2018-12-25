package com.teddy.dao;


import com.teddy.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Admin.class, id);
    }

    public List<Admin> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> query = session.createQuery("from Admin as s where s.name = ?1", Admin.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    public void saveOrUpdate(Admin admin) {
        sessionFactory.getCurrentSession().saveOrUpdate(admin);
    }

    public void update(Admin admin) {
        sessionFactory.getCurrentSession().update(admin);
    }

}
