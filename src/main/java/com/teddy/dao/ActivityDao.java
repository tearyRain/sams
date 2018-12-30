package com.teddy.dao;

import com.teddy.entity.Activity;
import com.teddy.entity.Sponsor;
import com.teddy.entity.Student;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        Query<Student> query = session.createQuery("select Student from Attendance where Activity.id = ?1 and Attendance.voluntary=false", Student.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Student> findActivityVolunteer(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("select Student from Attendance where Activity.id = ?1 and Attendance .voluntary=true", Student.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Activity> findAppliedVolunteer(Long pageNo, Long pageSize, Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT  Activity from Attendance where Student.id=?1 and Attendance.voluntary=true");
        query.setParameter(1, id);

        ScrollableResults scroll = query.scroll();
        scroll.last();
        int i = scroll.getRowNumber() + 1;

        query.setFirstResult(Math.toIntExact(pageNo));
        query.setMaxResults(Math.toIntExact(pageSize));

        return query.list();
    }

    public List<Activity> findCommentActivity(Long pageNo, Long pageSize, Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT  Activity from Attendance where Student.id=?1 and" +
                " Attendance.voluntary=true and Attendance .score=null and Activity.endTime>?2");
        query.setParameter(1, id);
        Date date = new Date();
        query.setParameter(2, date.getTime());

        ScrollableResults scroll = query.scroll();
        scroll.last();
        int i = scroll.getRowNumber() + 1;

        query.setFirstResult(Math.toIntExact(pageNo));
        query.setMaxResults(Math.toIntExact(pageSize));

        return query.list();
    }

    public List<Sponsor> findActivitySponsor(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Sponsor> query = session.createQuery("select Sponsor from Attendance where Activity.id = ?1", Sponsor.class);
        query.setParameter(1, id);
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
        return (int)session.createQuery("select count(*) from Activity as a").getSingleResult();
    }

    public List<Activity> findParticipatedActivity(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Activity> query = session.createQuery("select Activity from Attendance where Student .id = ?1", Activity.class);
        query.setParameter(1, id);
        return query.list();
    }

    public List<Activity> findAllActivity(Long pageNo, Long pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Activity ");

        //得到滚动结果集
        ScrollableResults scroll = query.scroll();
        //滚动到最后一行
        scroll.last();
        int i = scroll.getRowNumber() + 1;

        //设置分页位置
        query.setFirstResult(Math.toIntExact(pageNo));
        query.setMaxResults(Math.toIntExact(pageSize));

        return query.list();
    }

}
