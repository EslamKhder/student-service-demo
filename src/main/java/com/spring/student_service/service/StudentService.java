package com.spring.student_service.service;

import com.spring.student_service.model.Student;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;
import java.util.List;

@Service
public interface StudentService {

    void save(Student student) throws SystemException;
    void delete(Long id) throws SystemException;

    List<Student> fetchALLStudent() throws SystemException;
}
