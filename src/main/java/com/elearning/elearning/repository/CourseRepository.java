package com.elearning.elearning.repository;



import com.elearning.elearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Provides basic database CRUD operations for the Course entity
    @Query(value = "SELECT * FROM courses ORDER BY id DESC LIMIT 6", nativeQuery = true)
    List<Course> findTop6Courses();

}
