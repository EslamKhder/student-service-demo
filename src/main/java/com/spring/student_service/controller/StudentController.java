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

    @GetMapping("/getAllStudentByIds/{ids}")
    public List<Student> getAllStudent(@PathVariable("ids") List<Long> ids) throws SystemException {
        return studentService.fetchALLStudentByIds(ids);
    }

    @GetMapping("/student/isExist/{id}")
    public Boolean isStudentExist(@PathVariable("id") Long id) throws SystemException {
        return studentService.isExist(id);
    }

    @PostMapping("/saveAllStudent")
    public List<Student> saveStu(@RequestBody List<Student> student) throws SystemException {
        return studentService.save(student);
    }


    @GetMapping("/getAllByName/{name}")
    public List<Student> getAllStudent(@PathVariable("name") String name) throws SystemException {
        return studentService.findByName(name);
    }


    @GetMapping("/findByNameLike/{name}")
    public List<Student> findByNameLike(@PathVariable("name") String name) throws SystemException {
        return studentService.findByNameLike(name);
    }
}
