package com.teddy.service;

import com.teddy.dao.OrganizationDao;
import com.teddy.entity.Organization;
import com.teddy.vo.OrganizationVo;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganizationService {
    @Autowired
    OrganizationDao OrganizationDao;

    public boolean checkPassword(String email, String password) {
        assert email != null;
        Organization Organization = OrganizationDao.findByEmail(email);
        if (Organization == null) {
            return false;
        }
        return Organization.getPassword().equals(password);
    }

    public OrganizationVo findById(Long id) {
        return OrganizationVo.fromOrganization(OrganizationDao.findById(id));
    }

    public OrganizationVo findByEmail(String email) {
        return OrganizationVo.fromOrganization(OrganizationDao.findByEmail(email));
    }
}
