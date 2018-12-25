package com.teddy.dao;

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
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Student findById(Long id) {
        return sessionFactory.getCurrentSession().find(Student.class, id);
    }

    public List<Student> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("from Student as s where s.name = ?1", Student.class);
        query.setParameter(1, name);
        return query.list();
    }

    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    public void saveOrUpdate(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    public void update(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }
}
