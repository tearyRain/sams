package com.teddy.dao;


import com.teddy.entity.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Admin findById(Long id) {
        return sessionFactory.getCurrentSession().find(Admin.class, id);
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
