package com.mpena.demo.rest;

import com.mpena.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data... called once after bean constructed
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Elen", "Ripley"));
        theStudents.add(new Student("Wade", "Wilson"));
        theStudents.add(new Student("Eric", "Cartman"));
    }

    //return all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //retrieve a single student by id  - return at index in array list
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check the studentId against the list size
        if ( (studentId >= theStudents.size()) || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

}
