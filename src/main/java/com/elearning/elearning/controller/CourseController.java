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

    @PutMapping("/{id}/syllabus")
    public ResponseEntity<String> updateSyllabus(@PathVariable Long id, @RequestBody List<String> topics) {
        try {
            courseService.updateCourseSyllabus(id, topics);
            return ResponseEntity.ok("Syllabus updated successfully.");
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Course not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Error updating syllabus: " + e.getMessage());
            return new ResponseEntity<>("Failed to update syllabus.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Inside com.elearning.elearning.controller.CourseController

    /**
     * API: POST /api/courses/{id}/syllabus (Adds or replaces the syllabus for a course)
     * Note: This implementation behaves identically to PUT by replacing the entire list.
     */
    @PostMapping("/{id}/syllabus")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseEntity<String> addSyllabus(@PathVariable Long id, @RequestBody List<String> topics) {
        try {
            // We use the same service method as the goal is to set the new list of topics
            courseService.updateCourseSyllabus(id, topics);
            return new ResponseEntity<>("Syllabus added successfully.", HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Course not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Error adding syllabus: " + e.getMessage());
            return new ResponseEntity<>("Failed to add syllabus.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

 