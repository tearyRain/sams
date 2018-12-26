package com.teddy.view;

import com.teddy.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class StudentAttendanceView {
    private StudentView student;
    private Byte score;
    private Boolean voluntary;

    public static StudentAttendanceView fromAttendance(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        StudentAttendanceView studentAttendanceView = new StudentAttendanceView();
        BeanUtils.copyProperties(attendance, studentAttendanceView);
        studentAttendanceView.setStudent(StudentView.fromStudent(attendance.getStudent()));
        return studentAttendanceView;
    }
}
