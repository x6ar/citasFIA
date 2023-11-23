package edu.uam.citasFIA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Embeddable
@Getter @Setter
public class Correo {
    @Email
    String nombrecorreo;
}
