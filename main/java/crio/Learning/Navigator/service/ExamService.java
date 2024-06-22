package com.crio.learningnavigator.service;

import com.crio.learningnavigator.entity.Exam;
import com.crio.learningnavigator.entity.Student;
import com.crio.learningnavigator.exception.ErrorCode;
import com.crio.learningnavigator.exception.ResourceNotFoundException;
import com.crio.learningnavigator.repository.ExamRepository;
import com.crio.learningnavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Exam registerStudentForExam(Long examId, Long studentId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.EXAM_NOT_FOUND, studentId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.STUDENT_NOT_FOUND, studentId));

        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new IllegalArgumentException("Student must enroll in the subject before registering for the exam");
        }

        exam.getStudents().add(student);
        student.getExams().add(exam);

        studentRepository.save(student);
        return examRepository.save(exam);
    }


}