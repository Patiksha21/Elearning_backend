package com.elearning.elearning.controller;

import com.elearning.elearning.entity.Enrollment;
import com.elearning.elearning.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // ✅ allows frontend connection
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // ✅ Save new enrollment (POST)
    @PostMapping
    public Enrollment saveEnrollment(@RequestBody Enrollment enrollment) {
        System.out.println("📥 Received Enrollment for Course ID: " + enrollment.getCourseId());
        return enrollmentService.saveEnrollment(enrollment);
    }

    // ✅ Fetch all enrollments (GET)
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}
 
