package com.crio.learningnavigator.service;

import com.crio.learningnavigator.entity.Subject;
import com.crio.learningnavigator.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    public void testCreateSubject() {
        Subject subject = new Subject("Math", null);
        when(subjectRepository.save(subject)).thenReturn(subject);

        Subject createdSubject = subjectService.createSubject(subject);

        assertNotNull(createdSubject);
        assertEquals("Math", createdSubject.getName());
    }

    // Add more test cases as needed
}