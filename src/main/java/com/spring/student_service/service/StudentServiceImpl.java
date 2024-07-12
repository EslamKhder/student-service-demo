package com.spring.student_service.service;

import com.spring.student_service.model.Student;
import com.spring.student_service.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public void save(Student student) throws SystemException {
        if (student.getName().length() < 5) {
            throw new SystemException("name length must be greater than 5");
        }
        studentRepo.save(student);
    }

    @Override
    public void delete(Long id) throws SystemException {
        if (Objects.isNull(id)) {
            throw new SystemException("id must be not null");
        }

        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent()) {
            studentRepo.deleteById(id);
        } else {
            throw new SystemException("id not exist");
        }
    }

    @Override
    public List<Student> fetchALLStudent() throws SystemException {
        return studentRepo.findAll();
    }


}
