package com.crio.learningnavigator.service;

import com.crio.learningnavigator.entity.Exam;
import com.crio.learningnavigator.entity.Student;
import com.crio.learningnavigator.entity.Subject;
import com.crio.learningnavigator.exception.ErrorCode;
import com.crio.learningnavigator.exception.ResourceNotFoundException;
import com.crio.learningnavigator.repository.ExamRepository;
import com.crio.learningnavigator.repository.StudentRepository;
import com.crio.learningnavigator.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ExamRepository examRepository;

    public Student enrollSubject(Long registrationId, Long subjectId) {
        Student student = studentRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.STUDENT_NOT_FOUND, registrationId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.SUBJECT_NOT_FOUND, subjectId));

        student.getSubjects().add(subject);
        return studentRepository.save(student);
    }

    public Student registerExam(Long registrationId, Long examId) {
        Student student = studentRepository.findById(registrationId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.STUDENT_NOT_FOUND, registrationId));
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.EXAM_NOT_FOUND, examId));

        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new IllegalArgumentException("Student must enroll in the subject of the exam");
        }

        student.getExams().add(exam);
        return studentRepository.save(student);
    }
}