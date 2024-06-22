package com.crio.learningnavigator.service;

import com.crio.learningnavigator.entity.Exam;
import com.crio.learningnavigator.entity.Student;
import com.crio.learningnavigator.exception.ErrorCode;
import com.crio.learningnavigator.exception.ResourceNotFoundException;
import com.crio.learningnavigator.repository.ExamRepository;
import com.crio.learningnavigator.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ExamServiceTest {

    @Mock
    private ExamRepository examRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ExamService examService;

    @Test
    public void testRegisterStudentForExam_StudentNotFound() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> examService.registerStudentForExam(1L, 1L));
    }


}