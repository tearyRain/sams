package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Sponse
 */
@Entity
@Table(name = "SPONSE")
@Data
@NoArgsConstructor
public class Sponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Sponsor sponsor;

    @ManyToOne
    private Activity activity;

    @Type(type = "text")
    private String description;

}