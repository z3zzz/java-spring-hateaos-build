package com.information.informationRestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.information.informationRestful.models.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
