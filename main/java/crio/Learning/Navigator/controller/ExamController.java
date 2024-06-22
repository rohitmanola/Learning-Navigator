package com.crio.learningnavigator.controller;

import com.crio.learningnavigator.entity.Exam;
import com.crio.learningnavigator.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/{examId}")
    public ResponseEntity<Exam> registerStudentForExam(@PathVariable Long examId, @RequestParam Long studentId) {
        return ResponseEntity.ok(examService.registerStudentForExam(examId, studentId));
    }


}