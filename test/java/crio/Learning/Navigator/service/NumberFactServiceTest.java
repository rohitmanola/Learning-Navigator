package com.crio.learningnavigator.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest
public class NumberFactServiceTest {

    @InjectMocks
    private NumberFactService numberFactService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testGetNumberFact() {
        String expectedFact = "5 is the number of Platonic solids.";
        when(restTemplate.getForObject(anyString(), any())).thenReturn(expectedFact);

        String fact = numberFactService.getNumberFact(5);

        assertEquals(expectedFact, fact);
    }

}