package com.teddy.service;

import com.teddy.dao.AttendanceDao;
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

    /**
     *
     * @param studentAttendanceVo
     */
    public void insert(StudentAttendanceVo studentAttendanceVo){

    }
}
