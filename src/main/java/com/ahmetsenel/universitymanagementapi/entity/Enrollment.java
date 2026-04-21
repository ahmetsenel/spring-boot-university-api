package com.ahmetsenel.universitymanagementapi.entity;

import com.ahmetsenel.universitymanagementapi.entity.enums.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints =
        {@UniqueConstraint(columnNames = {"student_id", "course_id", "semester"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment extends BaseEntity{

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private Integer semester;

    @Enumerated(EnumType.STRING)
    private Grade grade;
}
