package com.information.informationrestful.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.information.informationrestful.models.Informations;
import com.information.informationrestful.repository.InformationRepository;
import com.information.informationrestful.exception.InformationNotFoundException;
import com.information.informationrestful.utils.ContentResponse;

@RestController
public class InformationController {
  private final InformationRepository repository;

  public InformationController(InformationRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/informations")
  List<Informations> all() {
    return repository.findAll();
  }

  @GetMapping("/informations/{title}")
  EntityModel<Informations> one(@PathVariable String title) {
    Informations information = repository.findByTitle(title)
      .orElseThrow(() -> new InformationNotFoundException(title));

    return EntityModel.of(information, //
          linkTo(methodOn(InformationController.class).one(title)).withSelfRel(),
          linkTo(methodOn(InformationController.class).all()).withRel("informations"));
        
  }

  @PostMapping("/informations")
  Informations add(@RequestBody Informations information) {
    return repository.save(information);
  }

  @PutMapping("/informations/{title}")
  ResponseEntity<Informations> update(@PathVariable String title, @RequestBody Informations newInformation) {
      Informations informations = repository.findByTitle(title)
                                  .orElseThrow(() -> new InformationNotFoundException(title));
      
      informations.setContent(newInformation.getContent());
      repository.save(informations);

      return ResponseEntity.ok(informations);
  }

  @DeleteMapping("/informations/{title}")
  ContentResponse delete(@PathVariable String title) {
    Long deletedCount = repository.deleteByTitle(title);

    if (deletedCount == 0)
      return new ContentResponse("삭제에 실패하였습니다.");
    else
      return new ContentResponse("삭제에 성공하였습니다.");
  }
}
