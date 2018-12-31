package com.teddy.dao;


import com.teddy.entity.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AttendanceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Attendance findById(Long id) {
        return sessionFactory.getCurrentSession().find(Attendance.class, id);
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

    public Attendance findByStudentAndActivity(Long studentId, Long activityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> query = session.createQuery(
                "from Attendance where student.id = ?1 and activity.id = ?2", Attendance.class);
        query.setParameter(1, studentId).setParameter(2, activityId);
        return query.getSingleResult();
    }

    public void delete(Attendance attendance) {
        sessionFactory.getCurrentSession().delete(attendance);
    }
}
