package com.teddy.dao;


import com.teddy.entity.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AttendanceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Attendance findById(Long id) {
        return sessionFactory.getCurrentSession().find(Attendance.class, id);
    }

    public Attendance findByStudentAndActivity(Long studentId, Long activityId){
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> query = session.createQuery("from Attendance where student.id = ?1 and activity.id = ?2");
        query.setParameter(1, studentId).setParameter(2, activityId);
        List<Attendance> list = query.list();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
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
