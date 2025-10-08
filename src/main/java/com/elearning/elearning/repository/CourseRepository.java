package com.elearning.elearning.repository;



import com.elearning.elearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Provides basic database CRUD operations for the Course entity
}
 