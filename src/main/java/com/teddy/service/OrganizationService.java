package com.teddy.service;

import com.teddy.dao.OrganizationDao;
import com.teddy.entity.Organization;
import com.teddy.vo.OrganizationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizationService {
    @Autowired
    OrganizationDao OrganizationDao;

    public Long login(String email, String password) {
        assert email != null;
        Organization organization = OrganizationDao.findByEmail(email);
        if (organization != null && organization.getPassword().equals(password) && !organization.getBanned()) {
            return organization.getId();
        }
        return null;
    }

    public OrganizationVo findById(Long id) {
        return OrganizationVo.fromOrganization(OrganizationDao.findById(id));
    }

    public OrganizationVo findByEmail(String email) {
        return OrganizationVo.fromOrganization(OrganizationDao.findByEmail(email));
    }
}
