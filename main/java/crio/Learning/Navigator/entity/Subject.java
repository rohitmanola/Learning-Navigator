package com.crio.learningnavigator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

    public Subject(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}