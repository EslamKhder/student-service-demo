package com.spring.student_service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.hibernate.Criteria;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String name;

    private String phone;
    private String email;



}
