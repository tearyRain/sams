package com.teddy.service;

import com.teddy.dao.AdminDao;
import com.teddy.dao.SponsorDao;
import com.teddy.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    SponsorDao sponsorDao;

    boolean checkAdminPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkStudentPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkSponsorPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkOrganization(Long id, String password) {
        // TODO
        return false;
    }
}
