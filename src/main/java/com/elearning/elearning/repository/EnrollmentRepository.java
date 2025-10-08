package com.elearning.elearning.repository;



import com.elearning.elearning.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// No need to write any implementation! Spring handles this.
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
