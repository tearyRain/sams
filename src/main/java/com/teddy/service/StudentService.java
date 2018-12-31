package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.dao.AttendanceDao;
import com.teddy.dao.StudentDao;
import com.teddy.entity.Activity;
import com.teddy.entity.Attendance;
import com.teddy.entity.Student;
import com.teddy.vo.ActivityVo;
import com.teddy.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private ActivityDao activityDao;

    public boolean checkPassword(Long id, String password) {
        Student student = studentDao.findById(id);
        if (student == null) {
            return false;
        }
        return student.getPassword().equals(password);
    }

    public StudentVo findById(Long id) {
        return StudentVo.fromStudent(studentDao.findById(id));
    }

    public List<ActivityVo> findParticipatedActivity(Long id) {
        if (studentDao.findById(id) == null) {
            return null;
        }
        List<Activity> list = studentDao.findParticipatedActivity(id);
        List<ActivityVo> res = new ArrayList<>();
        for (Activity activity : list) {
            res.add(ActivityVo.fromActivity(activity));
        }
        return res;
    }

    public boolean update(StudentVo studentVo){
        if(studentVo == null)
            return false;

        Student student = studentDao.findById(studentVo.getId());
        if(student == null)
            return false;

        BeanUtils.copyProperties(studentVo, student);
        studentDao.update(student);
        return true;
    }

    public boolean modifyPassword(Long studentId, String password){
        Student student = studentDao.findById(studentId);
        if(student == null)
            return false;

        student.setPassword(password);
        studentDao.update(student);
        return true;
    }

    public List<ActivityVo> findAppliedVolunteer(Long id) {
        if (studentDao.findById(id) == null) {
            return null;
        }
        List<Activity> list = studentDao.findAppliedVolunteer(id);
        List<ActivityVo> res = new ArrayList<>();
        for (Activity activity : list) {
            res.add(ActivityVo.fromActivity(activity));
        }
        return res;
    }

    public List<ActivityVo> findCommentActivity(Long id) {
        if (studentDao.findById(id) == null) {
            return null;
        }
        List<Activity> list = studentDao.findCommentActivity(id);
        List<ActivityVo> res = new ArrayList<>();
        for (Activity activity : list) {
            res.add(ActivityVo.fromActivity(activity));
        }
        return res;
    }

    public boolean revokeActivity(Long studentId, Long activityId, boolean voluntary) {
        Attendance attendance = attendanceDao.findByStudentAndActivity(studentId, activityId);
        if (attendance == null || attendance.getVoluntary() == voluntary) {
            return false;
        }
        Activity activity = activityDao.findById(activityId);
        if (activity == null) {
            return false;
        }
        if (activity.getEndTime().isBefore(LocalDateTime.now()))
            return false;
        attendanceDao.delete(attendance);
        return true;
    }

    public boolean revokeVolunteer(Long studentId, Long activityId) {
        return revokeActivity(studentId, activityId, true);
    }

    public boolean revokeParticipation(Long studentId, Long activityId) {
        return revokeActivity(studentId, activityId, false);
    }
}
