package com.ahmetsenel.universitymanagementapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity{

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String studentNumber;

    private LocalDate birthDate;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Lecturer advisor;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    @OneToOne()
    @JoinColumn(unique = true)
    private User user;
}
