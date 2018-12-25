package com.teddy.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SupportDao {
    @Autowired
    private SessionFactory sessionFactory;

}
