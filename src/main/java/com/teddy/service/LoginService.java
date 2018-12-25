package com.teddy.service;

import com.teddy.dao.*;
import com.teddy.entity.Admin;
import com.teddy.entity.Organization;
import com.teddy.entity.Sponsor;
import com.teddy.entity.Student;
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
    OrganizationDao organizationDao;

    @Autowired
    SupportDao supportDao;


    boolean checkAdminPassword(Long id, String password) {
        Admin admin = adminDao.findById(id);
        return admin.getPassword().equals(password);
    }

    boolean checkStudentPassword(Long id, String password) {
        Student student = studentDao.findById(id);
        return student.getPassword().equals(password);
    }

    boolean checkSponsorPassword(Long id, String password) {
        Sponsor sponsor = sponsorDao.findById(id);
        return sponsor.getPassword().equals(password);
    }

    boolean checkOrganizationPassword(Long id, String password) {
        Organization organization = organizationDao.findById(id);
        return organization.getPassword().equals(password);
    }

}
