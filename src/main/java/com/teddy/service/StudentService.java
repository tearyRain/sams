package com.teddy.service;

import com.teddy.dao.StudentDao;
import com.teddy.entity.Student;
import com.teddy.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    StudentVo findById(Long id) {
        return StudentVo.fromStudent(studentDao.findById(id));
    }
}
