package com.information.informationrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.information.informationrestful.models.Informations;

import java.util.Optional;


public interface InformationRepository extends JpaRepository<Informations, Long> {
  Optional<Informations> findByTitle(String title);
  
  @Transactional
  long deleteByTitle(String title);
}
