package com.arjun.fullstack_backend.repository;

import com.arjun.fullstack_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
JpaRepository<User,Long>
| Part   | Meaning                                                  |
| ------ | ---------------------------------------------------------|
| `User` | The entity class that this repository will manage.       |
| `Long` | The type of the primary key (ID) of the entity (`User`). |

Spring Data JPA automatically provides a full set of CRUD operations for your User entity.
| Method                | Description               |
| --------------------- | ------------------------- |
| `findAll()`           | Gets all users            |
| `findById(Long id)`   | Finds user by ID          |
| `save(User user)`     | Saves (or updates) a user |
| `deleteById(Long id)` | Deletes a user by ID      |


* */

public interface UserRepository extends JpaRepository<User,Long> {

}
