package com.student.crudactivity.dao;

import com.student.crudactivity.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO
{
    private EntityManager entityManager;
    public StudentDAOImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }

@Transactional
    public List<Student> findAll()
    {
        Session currentsession=entityManager.unwrap(Session.class);
       Query<Student> theQuery=currentsession.createQuery("from Student",Student.class);
       List<Student> students=theQuery.getResultList();
       return students;

    }
    public Student findById(int theId)
    {
        Session currentsession=entityManager.unwrap(Session.class);
        Student thestudent=currentsession.get(Student.class,theId);
        return thestudent;
    }
    public  void save(Student theStudent)
    {
        Session currentsession=entityManager.unwrap(Session.class);
        currentsession.saveOrUpdate(theStudent);

    }
    public void deleteById(int theId)
   {
       Session currentsession=entityManager.unwrap(Session.class);
       Query theQuery=currentsession.createQuery("delete from Student where id= :StudentId");
       theQuery.setParameter("StudentId",theId);
       theQuery.executeUpdate();


   }
}
