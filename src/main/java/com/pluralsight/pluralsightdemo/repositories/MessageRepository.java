package com.pluralsight.pluralsightdemo.repositories;

import com.pluralsight.pluralsightdemo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
