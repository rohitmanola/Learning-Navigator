package com.crio.learningnavigator.controller;

import com.crio.learningnavigator.entity.Student;
import com.crio.learningnavigator.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testEnrollSubject() throws Exception {
        Student student = new Student();
        student.setId(123L); // Assuming id is of type Long
        student.setName("John Doe");

        Mockito.when(studentService.enrollSubject(123L, 123L)).thenReturn(student);

        mockMvc.perform(post("/students/123/subjects/sub123")) // Using Long value for id
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(123)); // Assuming id is returned in response
    }

    @Test
    public void testRegisterExam() throws Exception {
        Student student = new Student();
        student.setId(123L); // Assuming id is of type Long
        student.setName("John Doe");

        // Mock the service method to return the student
        Mockito.when(studentService.registerExam(123L, 123L)).thenReturn(student);

        mockMvc.perform(post("/students/123/exams/exam123")) // Using Long value for id
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(123)); // Assuming id is returned in response
    }
}