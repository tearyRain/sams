package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.entity.Activity;
import com.teddy.entity.CheckStatus;
import com.teddy.entity.Sponsor;
import com.teddy.entity.Student;
import com.teddy.vo.ActivityVo;
import com.teddy.vo.SponsorVo;
import com.teddy.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public ActivityVo findById(long id){
        return ActivityVo.fromActivity(activityDao.findById(id));
    }

    public boolean checkActivity(Long id, Boolean pass) {
        Activity activity = activityDao.findById(id);
        if (activity == null) {
            return false;
        }
        if (pass) {
            activity.setCheckStatus(CheckStatus.APPROVED);
        } else {
            activity.setCheckStatus(CheckStatus.DECLINE);
        }
        activityDao.save(activity);
        return true;
    }

    public List<ActivityVo> viewActivity(Integer pageNo, Integer pageSize) {
        List<Activity> list = activityDao.findAllActivity(pageNo, pageSize);
        List<ActivityVo> res = new ArrayList<>();
        for (Activity activity : list) {
            ActivityVo vo = ActivityVo.fromActivity(activity);
            vo.setRemainAttendance(vo.getAttendanceNum() - activityDao.countParticipation(activity.getId()));
            vo.setRemainVolunteer(vo.getVolunteers() - activityDao.countVolunteers(activity.getId()));
            res.add(vo);
        }
        return res;
    }

    public List<StudentVo> findActivityParticipator(Long id) {
        if (activityDao.findById(id) == null)
            return null;
        List<Student> list = activityDao.findActivityParticipator(id);
        List<StudentVo> res = new ArrayList<>();
        for (Student student : list) {
            res.add(StudentVo.fromStudent(student));
        }
        return res;
    }

    public List<SponsorVo> findActivitySponsor(Long id) {
        if (activityDao.findById(id) == null)
            return null;
        List<Sponsor> list = activityDao.findActivitySponsor(id);
        List<SponsorVo> res = new ArrayList<>();
        for (Sponsor sponsor : list) {
            res.add(SponsorVo.fromSponsor(sponsor));
        }
        return res;
    }

    public List<StudentVo> findActivityVolunteer(Long id) {
        if (activityDao.findById(id) == null)
            return null;
        List<Student> list = activityDao.findActivityVolunteer(id);
        List<StudentVo> res = new ArrayList<>();
        for (Student student : list) {
            res.add(StudentVo.fromStudent(student));
        }
        return res;
    }

}
