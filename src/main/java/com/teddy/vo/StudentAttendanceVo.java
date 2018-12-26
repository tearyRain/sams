package com.teddy.vo;

import com.teddy.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class StudentAttendanceVo {
    private StudentVo student;
    private Byte score;
    private Boolean voluntary;

    public static StudentAttendanceVo fromAttendance(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        StudentAttendanceVo studentAttendanceView = new StudentAttendanceVo();
        BeanUtils.copyProperties(attendance, studentAttendanceView);
        studentAttendanceView.setStudent(StudentVo.fromStudent(attendance.getStudent()));
        return studentAttendanceView;
    }
}
