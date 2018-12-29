package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.dao.SupportDao;
import com.teddy.entity.Support;
import com.teddy.vo.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private SupportDao supportDao;

    public ActivityVo findById(long id){
        return ActivityVo.fromActivity(activityDao.findById(id));
    }

    public boolean selectSponsor(Long activityId, Long sponsorId) {
        Support support = supportDao.findByActivityAndSponsor(activityId, sponsorId);
        if (support != null) {
            support.setChosen(true);
            supportDao.save(support);
            return true;
        }
        return false;
    }
}
