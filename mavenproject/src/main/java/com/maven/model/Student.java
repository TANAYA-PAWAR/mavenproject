
//JPA- Java Persistence API
//JPA entity class
//@Entity- It identifies a class as an entity class
//@Table- It specifies the table in the database
//@Id- define the mapping to the primary key
//@GeneratedValue-used to automatically generate the primary key value

package com.maven.model;
import javax.persistence.*;
import lombok.*;
@Entity  
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor 	  // default constructor
@AllArgsConstructor  //parameterized constructor
@Data
public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    
}