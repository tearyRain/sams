package com.teddy.dao;

import com.teddy.entity.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Organization.class, id);
    }

    List<Organization> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Organization> query = session.createQuery("from Orgnization as s where s.name = ?1", Organization.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Organization organization) {
        sessionFactory.getCurrentSession().save(organization);
    }

    public void saveOrUpdate(Organization organization) {
        sessionFactory.getCurrentSession().saveOrUpdate(organization);
    }

    public void update(Organization organization) {
        sessionFactory.getCurrentSession().update(organization);
    }
}
