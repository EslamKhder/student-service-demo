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

    List<Student> fetchALLStudentByIds(List<Long> ids) throws SystemException;

    Boolean isExist(Long id);

    List<Student> save(List<Student> students) throws SystemException;


    List<Student> findByName(String name) throws SystemException;

    List<Student> findByNameLike(String name);
}
