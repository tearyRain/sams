package com.teddy.dao;


import com.teddy.entity.Attendance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AttendanceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void findById(Long id) {
        sessionFactory.getCurrentSession().find(Attendance.class, id);
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
