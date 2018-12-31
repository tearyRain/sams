package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.dao.OrganizationDao;
import com.teddy.entity.Activity;
import com.teddy.entity.CheckStatus;
import com.teddy.entity.ContactInfo;
import com.teddy.entity.Organization;
import com.teddy.vo.ActivityVo;
import com.teddy.vo.OrganizationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class OrganizationService {
    @Autowired
    OrganizationDao organizationDao;
    @Autowired
    ActivityDao activityDao;

    public Long login(String email, String password) {
        assert email != null;
        Organization organization = organizationDao.findByEmail(email);
        if (organization != null && organization.getPassword().equals(password) && !organization.getBanned()) {
            return organization.getId();
        }
        return null;
    }

    public OrganizationVo findById(Long id) {
        return OrganizationVo.fromOrganization(organizationDao.findById(id));
    }

    public OrganizationVo findByEmail(String email) {
        return OrganizationVo.fromOrganization(organizationDao.findByEmail(email));
    }

    public boolean updateInformation(OrganizationVo vo) {
        Organization organization = organizationDao.findById(vo.getId());
        if (organization == null) {
            return false;
        }
        BeanUtils.copyProperties(vo, organization);
        ContactInfo contact = new ContactInfo();
        BeanUtils.copyProperties(vo.getContact(), contact);
        organization.setContact(contact);
        organizationDao.update(organization);
        return true;
    }

    public boolean changePassword(Long id, String password) {
        Organization organization = organizationDao.findById(id);
        return organization != null && organization.getPassword().equals(password);
    }

    public Long register(OrganizationVo vo) {
        vo.setId(null);
        Organization organization = organizationDao.findByEmail(vo.getEmail());
        if (organization != null) return null;
        Organization newOrganization = new Organization();
        BeanUtils.copyProperties(vo, newOrganization);
        organizationDao.save(newOrganization);
        return newOrganization.getId();
    }

    public Long releaseActivity(ActivityVo vo) {
        Organization organization = organizationDao.findById(vo.getOrganization().getId());
        if (organization == null) return null;
        vo.setId(null);
        vo.setSubmittedTime(null);
        Activity activity = new Activity();
        activity.setCheckStatus(CheckStatus.UNCHECK);
        activity.setSubmittedTime(LocalDateTime.now());
        activity.setOrganization(organization);
        activityDao.save(activity);
        return activity.getId();
    }
}
