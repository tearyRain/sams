package com.teddy.service;

import com.teddy.dao.OrganizationDao;
import com.teddy.entity.Organization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Transactional
@ExtendWith(SpringExtension.class)

@ContextConfiguration("classpath:context.xml")

public class OrganizationRegisterTest {
    @Autowired
    OrganizationService organizationService;
    @Autowired
    OrganizationDao organizationDao;

    @Test
    @Rollback(true)
    void testRegister() {
        Organization organization = new Organization();
        organization.setPassword("pwd");
        organization.setEmail("11@qq.com");
        organization.setBanned(false);
        organizationDao.save(organization);
        assertNotNull(organization);
    }
}
