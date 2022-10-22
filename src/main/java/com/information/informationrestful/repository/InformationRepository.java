package com.informationRestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informationRestful.models.Information;

interface InformationRepository extends JpaRepository<Information, Long> {
}
