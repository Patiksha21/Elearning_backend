package com.elearning.elearning.controller;

import com.elearning.elearning.entity.Course;
import com.elearning.elearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    // Inside a Spring Boot Controller



    // Handles Pratiksha's GET /api/courses (List all courses)
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        // Calls the new method we are about to add in CourseService
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // API: POST /api/courses (Add course)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Course addCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // API: PUT /api/courses/{id} (Update course)
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    // API: DELETE /api/courses/{id} (Delete course)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    // API: GET /api/courses/{id}/syllabus (Fetch syllabus)
    @GetMapping("/{id}/syllabus")
    public List<String> fetchSyllabus(@PathVariable Long id) {
        return courseService.getCourseSyllabus(id);
    }

    // Also need GET by ID for the details page
    @GetMapping("/{id}")
    public Course getCourseDetail(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Handle 404 Not Found errors
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

 