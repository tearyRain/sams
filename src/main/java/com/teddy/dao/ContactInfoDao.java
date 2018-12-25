package com.teddy.dao;

import com.teddy.entity.ContactInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ContactInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(ContactInfo.class, id);
    }

    public List<ContactInfo> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<ContactInfo> query = session.createQuery("from ContactInfo as s where s.name = ?1", ContactInfo.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(ContactInfo contactInfo) {
        sessionFactory.getCurrentSession().save(contactInfo);
    }

    public void saveOrUpdate(ContactInfo contactInfo) {
        sessionFactory.getCurrentSession().saveOrUpdate(contactInfo);
    }

    public void update(ContactInfo contactInfo) {
        sessionFactory.getCurrentSession().update(contactInfo);
    }
}
