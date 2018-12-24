package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Attendance
 */
@Entity
@Table(name = "ATTENDANCE")
@Data
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Activity activity;

    @ManyToOne(optional = false)
    private Student student;

    private Byte score;

    private Boolean voluntary;

}