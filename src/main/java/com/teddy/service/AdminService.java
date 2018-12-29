package com.teddy.service;

import com.teddy.dao.AdminDao;
import com.teddy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public boolean checkPassword(Long id, String password) {
        assert id != null;
        Admin admin = adminDao.findById(id);
        if (admin == null) {
            return false;
        }
        return admin.getPassword().equals(password);
    }
}
