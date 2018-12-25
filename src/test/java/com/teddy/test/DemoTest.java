package com.teddy.test;

import com.teddy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MyTest
 */

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:context.xml")
public class DemoTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @DisplayName("这是测例描述")
    void testAddStudent() {
        Session session = sessionFactory.getCurrentSession();
        Student student = new Student();
        student.setName("sss");
        student.setId(189090909l);
        session.persist(student);
        assertEquals("sss", student.getName());
    }

    // 在每个测例执行之前
    @BeforeEach
    void setUp() {

    }

    // 在每个测例执行之后
    @AfterEach
    void tearDown() {

    }

}