package com.example.spring.jpastudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto dto){
        Student student = StudentMapper.INSTANCE.toStudent(dto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.INSTANCE.toStudentResponseDto(savedStudent);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{students-id}")
    public Student findStudentById(@PathVariable("students-id") Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{students-name}")
    public List<Student> findStudentByName(@PathVariable("students-name") String firstname){
        return studentRepository.findAllByFirstnameContaining(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id){
        studentRepository.deleteById(id);
    }
}
