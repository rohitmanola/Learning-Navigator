package com.crio.learningnavigator.controller;

import com.crio.learningnavigator.entity.Subject;
import com.crio.learningnavigator.service.SubjectService;
import com.crio.learningnavigator.service.NumberFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private NumberFactService numberFactService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    // Easter Egg Feature
    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        String fact = numberFactService.getNumberFact(number);
        return new ResponseEntity<>(fact, HttpStatus.OK);
    }

    // Implement other endpoints as needed
}