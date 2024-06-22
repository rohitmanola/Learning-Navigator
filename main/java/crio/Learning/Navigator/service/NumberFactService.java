package com.crio.learningnavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumberFactService {
    @Autowired
    private RestTemplate restTemplate;

    public String getNumberFact(int number) {
        String url = "http://numbersapi.com/" + number;
        return restTemplate.getForObject(url, String.class);
    }
}