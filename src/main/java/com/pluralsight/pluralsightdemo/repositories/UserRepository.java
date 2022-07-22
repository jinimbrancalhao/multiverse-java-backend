package com.pluralsight.pluralsightdemo.repositories;

import com.pluralsight.pluralsightdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
