package com.teddy.dao;

import com.teddy.entity.Support;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Support findByActivityAndSponsor(Long activityId, Long sponsorId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Support> query = session.createQuery(
                "from Support where activity.id = ?1 and sponsor.id = ?2", Support.class);
        query.setParameter(1, activityId).setParameter(2, sponsorId);
        List<Support> list = query.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
