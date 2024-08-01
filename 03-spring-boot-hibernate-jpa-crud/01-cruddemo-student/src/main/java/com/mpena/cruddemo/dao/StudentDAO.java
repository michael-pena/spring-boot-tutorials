package com.mpena.cruddemo.dao;

import com.mpena.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> FindAll();

    List<Student> FindByLastName(String studentLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
