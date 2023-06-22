//method implementation of IStudentDao interface

package com.maven.dao;

import java.util.*;

import org.hibernate.*;

import com.maven.model.Student;
import com.maven.util.HibernateUtil;

public class StudentDao implements IStudentDao
{
	// save Student
    // get All Students
    // get Student By Id
    // Update Student
    // Delete Student
	
	@Override
	public void saveStudent(Student student) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(student);

            // commit the transaction
            transaction.commit();
        }
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();
            }
        }
    }
	@Override
	public void updateStudent(Student student) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(student);

            // commit the transaction
            transaction.commit();
        } 
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
        }
    }
	@Override
	public Student getStudentById(int id) 
	{
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get student object
            student = session.get(Student.class, id);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } 
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
        }
        return student;
    }
	@Override
	//indicates the named complier warning should be suppressed
	//@SuppressWarnings("unchecked")
    public List < Student > getAllStudents() 
	{
        Transaction transaction = null;
        List < Student > students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            students = session.createQuery("from Student").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }
	@Override
	public void deleteStudent(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);
            // get student object
            session.delete(student);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
               // transaction.rollback();
            }
        }
    }
}
