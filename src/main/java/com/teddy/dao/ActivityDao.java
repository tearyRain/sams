package com.teddy.dao;

import com.teddy.entity.Activity;
import com.teddy.entity.Sponsor;
import com.teddy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ActivityDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Activity findById(Long id) {
        return sessionFactory.getCurrentSession().find(Activity.class, id);
    }

    public List<Activity> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Activity> query = session.createQuery("from Activity as s where s.name = ?1", Activity.class);
        query.setParameter(1, name);
        return query.list();
    }

    public List<Student> findActivityParticipator(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery(
                "select student from Attendance where Activity.id = ?1 and voluntary=false", Student.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Student> findActivityVolunteer(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery(
                "select student from Attendance where activity.id = ?1 and voluntary = true", Student.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Student> findAppliedVolunteer(Integer pageNo, Integer pageSize, Long activityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery(
                "SELECT student from Attendance " +
                        "where activity.id = ?1 and voluntary = true ", Student.class);
        query.setParameter(1, activityId);
        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public List<Sponsor> findActivitySponsor(Long activityId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Sponsor> query = session.createQuery("select sponsor from Support where activity.id = ?1", Sponsor.class);
        query.setParameter(1, activityId);
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

    public int count(){
        Session session = sessionFactory.getCurrentSession();
        return (int) session.createQuery("select count(*) from Activity").getSingleResult();
    }

    public List<Activity> findParticipatedActivity(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Activity> query = session.createQuery("select activity from Attendance where student.id = ?1", Activity.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Activity> findAllActivity(Integer pageNo, Integer pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query<Activity> query = session.createQuery("from Activity order by endTime desc", Activity.class);
        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public Integer countVolunteers(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "select count(*) from Attendance where activity.id = ?1 and voluntary = true");
        query.setParameter(1, id);
        return ((Long)query.getSingleResult()).intValue();
    }

    public Integer countParticipation(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "select count(*) from Attendance where activity.id = ?1 and voluntary = false");
        query.setParameter(1, id);
        return  ((Long)query.getSingleResult()).intValue();
    }
}
