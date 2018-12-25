package com.teddy.dao;

import com.teddy.entity.Sponsor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SponsorDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Sponsor.class, id);
    }

    public List<Sponsor> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Sponsor> query = session.createQuery("from Sponsor as s where s.name = ?1", Sponsor.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Sponsor sponsor) {
        sessionFactory.getCurrentSession().save(sponsor);
    }

    public void saveOrUpdate(Sponsor sponsor) {
        sessionFactory.getCurrentSession().saveOrUpdate(sponsor);
    }

    public void update(Sponsor sponsor) {
        sessionFactory.getCurrentSession().update(sponsor);
    }
}
