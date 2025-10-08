package com.elearning.elearning.service;



import com.elearning.elearning.entity.Course;
import com.elearning.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private CourseRepository courseRepository;

    // Fetch only the latest 6 courses for the homepage
    public List<Course> getLatestCourses() {
        return courseRepository.findTop6Courses();
    }
}



