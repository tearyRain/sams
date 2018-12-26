package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Activity
 */
@Entity
@Table(name = "ACTIVITY")
@Data
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Organization organization;

    @Column(length = 127)
    private String name;

    @Type(type = "text")
    private String description;

    private Integer attendanceNum;

    private Integer volunteers;

    @Type(type = "text")
    private String volunteerRequired;

    @Type(type = "text")
    private String sponsorRequired;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.ORDINAL)
    private CheckStatus checkStatus;

    private Long totalStudentScore;

    private Long studentScoreNum;

    private LocalDateTime submittedTime;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<Attendance> attendanceSet = new HashSet<>();

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<Support> sponsorSet = new HashSet<>();

}