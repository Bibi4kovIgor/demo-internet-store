package edu.lemon.demointernetstore.model.repository;

import edu.lemon.demointernetstore.model.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  User findByName(String name);
}
