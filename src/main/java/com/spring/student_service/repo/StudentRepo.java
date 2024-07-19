package com.spring.student_service.repo;

import com.spring.student_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    @Query(value = "SELECT s FROM Student s WHERE s.name LIKE %?1%", nativeQuery = false)
    List<Student> findByNameLike(String name);

}
