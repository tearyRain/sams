package com.teddy.dao;

import com.teddy.entity.Support;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SupportDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Support findById(Long id) {
        return sessionFactory.getCurrentSession().find(Support.class, id);
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
