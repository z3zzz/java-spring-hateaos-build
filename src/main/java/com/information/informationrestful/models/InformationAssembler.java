package com.information.informationrestful.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.information.informationrestful.controllers.InformationController;

@Component
public class InformationAssembler implements RepresentationModelAssembler<Informations, EntityModel<Informations>> {
  
  @Override
  public EntityModel<Informations> toModel (Informations information) {
    return EntityModel.of(information, 
            linkTo(methodOn(InformationController.class).one(information.getTitle())).withSelfRel(),
            linkTo(methodOn(InformationController.class).all()).withRel("informations")
          );
  }
}
