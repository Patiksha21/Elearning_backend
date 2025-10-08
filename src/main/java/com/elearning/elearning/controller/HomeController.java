package com.elearning.elearning.controller;



import com.elearning.elearning.entity.Course;
import com.elearning.elearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private CourseService courseService;

    // ✅ API: GET /api/home/courses → Fetch only first 6 latest courses for homepage
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getLatestCourses() {
        List<Course> allCourses = courseService.getAllCourses();
        // Return only the first 6 courses (or less if fewer exist)
        List<Course> latestCourses = allCourses.stream()
                                               .limit(6)
                                               .toList();
        return new ResponseEntity<>(latestCourses, HttpStatus.OK);
    }


    // (Optional) Add other sections later, like testimonials, categories, etc.
}

