package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Support
 */
@Entity
@Table(name = "SUPPORT")
@Data
@NoArgsConstructor
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Sponsor sponsor;

    @ManyToOne
    private Activity activity;

    @Type(type = "text")
    private String description;

    private boolean isChoose;

}