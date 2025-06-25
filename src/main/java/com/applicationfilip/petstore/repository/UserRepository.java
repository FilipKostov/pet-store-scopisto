package com.applicationfilip.petstore.repository;

import com.applicationfilip.petstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

