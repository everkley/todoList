package org.evercley.repositories;

import org.evercley.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public Boolean existsByUsername(String username);
}
