package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.entity.Activity;
import com.teddy.vo.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public ActivityVo findById(long id){
        return ActivityVo.fromActivity(activityDao.findById(id));
    }
}
