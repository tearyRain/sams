package com.teddy.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SponsorDao {
    @Autowired
    private SessionFactory sessionFactory;

}
