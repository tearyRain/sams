package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Organization
 */
@Entity
@Table(name = "ORGANIZATION")
@Data
@NoArgsConstructor
public class Organization {
    @SequenceGenerator(name = "ORGANIZATION_ID_GENERATOR", allocationSize = 1, initialValue = 100000)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANIZATION_ID_GENERATOR")
    private Long id;

    @Column(length = 127)
    private String name;

    @Column(length = 32)
    private String password;

    @Embedded
    private ContactInfo contact;

    @NaturalId
    @Column(length = 127, unique = true)
    private String email;

    @Type(type = "text")
    private String description;

    private Boolean banned;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private Set<Activity> activities = new HashSet<>();

}