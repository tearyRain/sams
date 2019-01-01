package com.teddy.service;

import com.teddy.dao.ActivityDao;
import com.teddy.dao.AttendanceDao;
import com.teddy.dao.StudentDao;
import com.teddy.entity.Activity;
import com.teddy.entity.Attendance;
import com.teddy.entity.Student;
import com.teddy.vo.AttendedActivityVo;
import com.teddy.vo.StudentAttendanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ActivityDao activityDao;

    public boolean applyParticipation(Long studentId, Long activityId, boolean voluntary){
        Attendance attendance = new Attendance();

        Student student = studentDao.findById(studentId);
        if(student == null)
            return false;

        Activity activity = activityDao.findById(activityId);
        if(activity == null)
            return false;

        attendance.setActivity(activity);
        attendance.setStudent(student);
        attendance.setVoluntary(voluntary);
        attendanceDao.save(attendance);
        return true;
    }

    public boolean evaluateActivity(Long studentId, Long activityId, Integer score){
        Attendance attendance = attendanceDao.findByStudentAndActivity(studentId, activityId);
        if(attendance == null)
            return false;

        Activity activity = activityDao.findById(activityId);
        if(activity == null)
            return false;

        attendance.setScore(score.byteValue());
        activity.setStudentScoreNum(activity.getStudentScoreNum() + 1); // 打分人数加一
        activity.setTotalStudentScore(activity.getTotalStudentScore() + score); // 加总分
        attendanceDao.update(attendance);
        activityDao.update(activity);
        return true;
    }
}
