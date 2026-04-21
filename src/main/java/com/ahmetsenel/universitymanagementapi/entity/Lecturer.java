package com.ahmetsenel.universitymanagementapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends BaseEntity{

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String title;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "lecturer")
    private List<Course> courses;

    @OneToMany(mappedBy = "advisor")
    private List<Student> students;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;
}
