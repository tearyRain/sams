package com.teddy.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AttendanceDao {
    @Autowired
    private SessionFactory sessionFactory;

}
