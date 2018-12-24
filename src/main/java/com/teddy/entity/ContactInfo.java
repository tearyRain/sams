package com.teddy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

/**
 * ContactInfo
 */
@Embeddable
@Data
@NoArgsConstructor
public class ContactInfo {
    @Column(length = 127, name = "contactName")
    private String name;

    @Column(length = 127)
    private String phone;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

}