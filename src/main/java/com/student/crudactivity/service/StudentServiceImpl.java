package com.student.crudactivity.service;

import com.student.crudactivity.dao.StudentDAO;
import com.student.crudactivity.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService
{

    private StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO)
    {
        studentDAO=theStudentDAO;
    }
    @Transactional
    public List<Student> findAll()
    {
        return studentDAO.findAll();
    }
    @Transactional
    public Student findById(int theId)
    {
        return studentDAO.findById(theId);

    }
    @Transactional
    public void save(Student theStudent)
    {
        studentDAO.save(theStudent);
    }
    @Transactional
    public void deleteById(int theId)
    {
        studentDAO.deleteById(theId);

    }
}
