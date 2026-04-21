package com.ahmetsenel.universitymanagementapi.repository;

import com.ahmetsenel.universitymanagementapi.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findEnrollmentsByStudentId(Long studentId);
}
