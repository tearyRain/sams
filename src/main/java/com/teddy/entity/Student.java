package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student
 */
@Entity
@Table(name = "STUDENT")
@Data
@NoArgsConstructor
public class Student {
    @Id
    private Long id;

    @Column(length = 127)
    private String name;

    @Column(length = 32)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(length = 127)
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    private Boolean banned;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Attendance> attendanceSet = new HashSet<>();

}