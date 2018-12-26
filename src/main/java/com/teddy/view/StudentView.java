package com.teddy.view;

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
public class StudentView {
    private Long id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String phone;

    private LocalDate enrollmentDate;
    private Boolean banned;
    private List<AttendedActivityView> activityList;

    static public StudentView fromStudent(Student student) {
        if (student == null) return null;
        StudentView studentView = new StudentView();
        BeanUtils.copyProperties(student, studentView);
        return studentView;
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
