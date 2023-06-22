package com.maven;

import java.util.*;
import com.maven.dao.*;
import com.maven.model.*;
public class App 
{
    public static void main( String[] args )
    {
    	StudentDao studentDao = new StudentDao();

        // test saveStudent
        Student student =new Student();
        
        //Add values
        student.setFirstName("Tanaya");
        student.setLastName("Pawar");
        student.setEmail("tanayapawar530@gmail.com");
      
        
        //passing value in parameterized constructor
        studentDao.saveStudent(student);
        

        
        // test updateStudent
         student.setFirstName("Pari");
         studentDao.updateStudent(student);
        
        // test getStudentById
        //Student student2 = studentDao.getStudentById(student.getId());

        // test getAllStudents
        List < Student > students = studentDao.getAllStudents();
        System.out.println("List of the students:"); 
        students.forEach(student2 -> System.out.println("Student Id:"+student2.getId()+"    " +"Name:"+student2.getFirstName()+"   " +"Last Name:"+student2.getLastName()+"   " +"Email Id:"+student2.getEmail()));
        // -> lambda expression left side of arrow:parameter ; right:value
        
        // test deleteStudent
        //studentDao.deleteStudent(1);

    }
    }



