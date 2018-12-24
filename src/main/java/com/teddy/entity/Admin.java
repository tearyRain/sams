package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Admin
 */
@Entity
@Table(name = "ADMIN")
@Data
@NoArgsConstructor
public class Admin {
    @SequenceGenerator(name = "ADMIN_ID_GENERATOR", allocationSize = 1, initialValue = 100000)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_ID_GENERATOR")
    private Long id;

    @Column(length = 32)
    private String password;

}