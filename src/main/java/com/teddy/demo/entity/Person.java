package com.teddy.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
}