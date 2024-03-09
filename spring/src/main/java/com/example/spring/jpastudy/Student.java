package com.example.spring.jpastudy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="T_STUDENT")
@Data
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column
    private int age;

    @OneToOne(mappedBy = "student", // 관계의 주인
                cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference // 무한루프 방지 (child에)
    private School school;

}
