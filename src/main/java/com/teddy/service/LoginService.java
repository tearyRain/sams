package com.teddy.service;

import com.teddy.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    SponsorDao sponsorDao;

    @Autowired
    AttendanceDao attendanceDao;

    @Autowired
    ContactInfoDao contactInfoDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SupportDao supportDao;


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

    boolean checkOrganizationPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkAttendancePassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkSupportPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkActivityPassword(Long id, String password) {
        // TODO
        return false;
    }

    boolean checkContactInfoPassword(Long id, String password) {
        // TODO
        return false;
    }
}
