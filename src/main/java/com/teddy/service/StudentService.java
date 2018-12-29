package com.teddy.service;

import com.teddy.dao.StudentDao;
import com.teddy.entity.Activity;
import com.teddy.entity.Student;
import com.teddy.vo.ActivityVo;
import com.teddy.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;

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
        List<Activity> list = studentDao.findParticipatedActivity(id);
        List<ActivityVo> res = new ArrayList<>();
        for (Activity activity : list) {
            res.add(ActivityVo.fromActivity(activity));
        }
        return res;
    }
}
