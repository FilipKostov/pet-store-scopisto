package com.applicationfilip.petstore.repository;

import com.applicationfilip.petstore.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {}
