package com.teddy.dao;

import com.teddy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Long save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return student.getId();
    }

}
