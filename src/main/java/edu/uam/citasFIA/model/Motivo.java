package edu.uam.citasFIA.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.model.Identifiable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Motivo extends Identifiable {
    private String nombreMotivo;
    private Integer duracion;
}
