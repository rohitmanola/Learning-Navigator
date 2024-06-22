package com.crio.learningnavigator.controller;

import com.crio.learningnavigator.entity.Student;
import com.crio.learningnavigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{registrationId}/subjects/{subjectId}")
    public ResponseEntity<Student> enrollSubject(@PathVariable Long registrationId, @PathVariable Long subjectId) {
        Student student = studentService.enrollSubject(registrationId, subjectId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/{registrationId}/exams/{examId}")
    public ResponseEntity<Student> registerExam(@PathVariable Long registrationId, @PathVariable Long examId) {
        Student student = studentService.registerExam(registrationId, examId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}