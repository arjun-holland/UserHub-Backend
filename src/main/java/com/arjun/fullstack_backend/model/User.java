package com.arjun.fullstack_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Entity annotation automatically generates the "User table"
// once we connect the spring boot application with mysql database
public class User {
    @Id
    //Purpose: Marks the primary key of a JPA entity, Without @Id, JPA wouldn't know which field is the unique identifier for each row in the database.Required for every @Entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //This tells JPA/Hibernate:
    //“Let the database automatically generate the value for the id when inserting a new row.”

    private Long id; //private Long id; This means : Each User in the database will have a unique ID.

    private String username;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

/*
JPA stands for Java Persistence API.
It’s a specification (a set of rules) in Java that helps you:
✅ Save,
✅ Update,
✅ Delete, and
✅ Get data
from a database using Java classes

🏡 Real-Life Analogy:
Imagine you're running a library. You have:
A notebook where you write down all the books (this is like your database).
And you have Book objects in your software, like:
    Book book = new Book("Harry Potter", "J.K. Rowling");
Now, instead of manually writing SQL like:
    INSERT INTO books (title, author) VALUES ('Harry Potter', 'J.K. Rowling');
JPA lets you write:
    bookRepository.save(book);
✨ It automatically saves your Java object into the database.


⚙️ How JPA Works (Simplified):
1. You Create a Java Class (Entity):create user MODEL
    @Entity
    public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;
      private String email;
    }
     This tells JPA:
    “Hey, this User class is like a table in the database.”
2. Use a Repository Interface:
    public interface UserRepository extends JpaRepository<User, Long> {
    }
    This gives you built-in methods like:
    save() – to add or update a user
    findAll() – to get all users
    deleteById() – to delete a user by ID
    No need to write SQL for any of this! 😎
3. You Use It in Your Controller/Service:
      @GetMapping
      public List<User> getAllUsers() {
        return userRepository.findAll();
      }
* */