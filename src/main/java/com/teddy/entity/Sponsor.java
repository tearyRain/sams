package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Sponsor
 */
@Entity
@Table(name = "SPONSOR")
@Data
@NoArgsConstructor
public class Sponsor {
    @SequenceGenerator(name = "SPONSOR_ID_GENERATOR", allocationSize = 1, initialValue = 100000)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPONSOR_ID_GENERATOR")
    private Long id;

    @Column(length = 127)
    private String name;

    @Column(length = 32)
    private String password;

    private ContactInfo contact;

    @NaturalId
    @Column(length = 127, unique = true)
    private String email;

    @Column(length = 127)
    private String address;

    @Type(type = "text")
    private String description;

    private Boolean banned;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL)
    private Set<Support> sponsorSet = new HashSet<>();


}