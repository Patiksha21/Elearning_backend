package com.elearning.elearning.service;


import com.elearning.elearning.entity.Course;
import com.elearning.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // POST /api/courses
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // PUT /api/courses/{id}
    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found with id: " + id));

        // Update fields
        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setSyllabus(updatedCourse.getSyllabus());
        existingCourse.setImageUrl(updatedCourse.getImageUrl());

        return courseRepository.save(existingCourse);
    }
    // Handles Pratiksha's GET /api/courses (List all courses)
    public List<Course> getAllCourses() {
        // Uses the inherited findAll() method from JpaRepository
        return courseRepository.findAll();
    }

    // DELETE /api/courses/{id}
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new NoSuchElementException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

    // GET /api/courses/{id}
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found with id: " + id));
    }

    // GET /api/courses/{id}/syllabus
    public List<String> getCourseSyllabus(Long id) {
        Course course = getCourseById(id);
        return course.getSyllabus();

    }

    public void updateCourseSyllabus(Long courseId, List<String> topics) {
        // 1. Find the existing course
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found with id: " + courseId));

        // 2. Set the new list of topics
        existingCourse.setSyllabus(topics);

        // 3. Save the modified course entity back to the database
        courseRepository.save(existingCourse);
    }

}
 
