package com.example.pract5.controller;

import com.example.pract5.model.Student;
import com.example.pract5.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/Student/")
public class StudentApiController {
    private final StudentRepository studentRepository;

    public StudentApiController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents(){return studentRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){return studentRepository.findById(id);}
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return  studentRepository.save(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        return  studentRepository.save(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
