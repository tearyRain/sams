package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.dao.SponsorDao;
import com.teddy.dao.SupportDao;
import com.teddy.entity.Activity;
import com.teddy.entity.Sponsor;
import com.teddy.entity.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupportService {
    @Autowired
    private SupportDao supportDao;

    @Autowired
    private SponsorDao sponsorDao;

    @Autowired
    private ActivityDao activityDao;

    public boolean insert(Long sponsorId, Long activityId, String description){
        Support support = new Support();

        Sponsor sponsor = sponsorDao.findById(sponsorId);
        if(sponsor == null)
            return false;

        Activity activity = activityDao.findById(activityId);
        if(activity == null)
            return false;

        support.setSponsor(sponsor);
        support.setActivity(activity);
        support.setDescription(description);
        support.setChosen(false);
        supportDao.save(support);
        return true;
    }

    public boolean selectSponsor(Long activityId, Long sponsorId){
        Support support = supportDao.findByActivityAndSponsor(activityId, sponsorId);
        if(support == null)
            return false;

        support.setChosen(true);
        supportDao.update(support);
        return true;
    }
}
