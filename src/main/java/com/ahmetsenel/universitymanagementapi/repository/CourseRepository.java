package com.ahmetsenel.universitymanagementapi.repository;

import com.ahmetsenel.universitymanagementapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
