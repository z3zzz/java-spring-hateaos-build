package com.information.informationRestful.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.information.informationRestful.repository.InformationRepository;

@Configuration
class LoadDatabase {
  private static final Long log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(InformationRepository repository) {
    return args -> {
      log.info("Preloading..." + repository.save(new Information("self_introduction", "안녕하세요, 백엔드 개발자입니다.")))
      log.info("Preloading..." + repository.save(new Information("self_cartoon", "원피스 최고!!!!!")))
    };
  }
}
