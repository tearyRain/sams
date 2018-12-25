package com.teddy.dao;

import com.teddy.entity.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Activity.class, id);
    }

    public List<Activity> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Activity> query = session.createQuery("from Activity as s where s.name = ?1", Activity.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Activity activity) {
        sessionFactory.getCurrentSession().save(activity);
    }

    public void saveOrUpdate(Activity activity) {
        sessionFactory.getCurrentSession().saveOrUpdate(activity);
    }

    public void update(Activity activity) {
        sessionFactory.getCurrentSession().update(activity);
    }

}
