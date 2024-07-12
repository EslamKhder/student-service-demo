package com.spring.student_service.controller;

import com.spring.student_service.model.Student;
import com.spring.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public void saveStu(@RequestBody Student student) throws SystemException {
        studentService.save(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStu(@PathVariable Long id) throws SystemException {
        studentService.delete(id);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() throws SystemException {
        return studentService.fetchALLStudent();
    }
}
