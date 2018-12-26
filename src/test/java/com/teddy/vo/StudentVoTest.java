package com.teddy.vo;

import com.teddy.entity.Gender;
import com.teddy.entity.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentVoTest {

    @Test
    void testFromStudent() {
        Student student = new Student();
        student.setId(12L);
        student.setName("送");
        student.setBanned(true);
        LocalDate localDate = LocalDate.of(2012, 12, 12);
        student.setBirthday(localDate);
        student.setGender(Gender.FEMALE);
        student.setPhone("128");
        student.setEnrollmentDate(localDate);
        StudentVo studentView = StudentVo.fromStudent(student);

        assertEquals(new Long(12L), studentView.getId());
        assertEquals("送", studentView.getName());
        assertEquals(true, studentView.getBanned());
        assertEquals(localDate, studentView.getBirthday());
        assertEquals(Gender.FEMALE, studentView.getGender());
        assertEquals("128", studentView.getPhone());
        assertEquals(localDate, studentView.getEnrollmentDate());
    }
}
