package com.student.crudactivity.dao;

import com.student.crudactivity.entity.Student;

import java.util.List;

public interface StudentDAO

{
    public List<Student> findAll();
    public Student findById(int theId);
    public  void save(Student theStudent);
    public void deleteById(int theId);
}
