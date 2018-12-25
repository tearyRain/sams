package com.teddy.dao;


import com.teddy.entity.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendanceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Attendance.class, id);
    }

    public List<Attendance> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> query = session.createQuery("from Attendance as s where s.name = ?1", Attendance.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Attendance attendance) {
        sessionFactory.getCurrentSession().save(attendance);
    }

    public void saveOrUpdate(Attendance attendance) {
        sessionFactory.getCurrentSession().saveOrUpdate(attendance);
    }

    public void update(Attendance attendance) {
        sessionFactory.getCurrentSession().update(attendance);
    }
}
