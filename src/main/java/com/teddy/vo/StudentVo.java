package com.teddy.vo;

import com.teddy.entity.Gender;
import com.teddy.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentVo {
    private Long id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String phone;

    private LocalDate enrollmentDate;
    private Boolean banned;
    private List<AttendedActivityVo> activityList;

    static public StudentVo fromStudent(Student student) {
        if (student == null) return null;
        StudentVo studentView = new StudentVo();
        BeanUtils.copyProperties(student, studentView);
        return studentView;
    }

    public Student toStudent(StudentVo studentVo){
        Student student = new Student();
        BeanUtils.copyProperties(student, studentVo);
        return student;
    }

    @JSON(format = "yyyy-MM-dd")
    public LocalDate getBirthday() {
        return birthday;
    }

    @JSON(format = "yyyy-MM-dd")
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
}
