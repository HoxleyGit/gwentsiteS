package com.example.gwentsiteS.repositories;

import com.example.gwentsiteS.entries.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
