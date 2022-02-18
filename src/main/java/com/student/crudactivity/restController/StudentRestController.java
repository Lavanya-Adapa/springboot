package com.student.crudactivity.restController;

import com.student.crudactivity.entity.Student;
import com.student.crudactivity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    private StudentService studentService;
    @Autowired
    public StudentRestController(StudentService theStudentService)
    {
        studentService=theStudentService;

    }
    @GetMapping("/students")
    public List<Student> findAll()
    {
        return studentService.findAll();
    }
    @GetMapping("/students/{studentId}")
    public Student findById(@PathVariable int StudentId)
    {
        Student theStudent=studentService.findById(StudentId);
         if(theStudent==null) {
             throw new RuntimeException("Student Id not found: -" + StudentId);
         }
         return theStudent;
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent)
    {
        theStudent.setId(0);
        studentService.save(theStudent);
        return theStudent;

    }
    @PutMapping("/students")
    public Student UpdateStudent(@RequestBody Student theStudent)
    {
        studentService.save(theStudent);
        return theStudent;

    }
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId)
    {
       Student tempStudent=studentService.findById(studentId);
       if(tempStudent==null)
       {
           throw new RuntimeException("Student not found with Id:"+studentId);

       }
       studentService.deleteById(studentId);
       return "Deleted student id:"+studentId;

    }


}
