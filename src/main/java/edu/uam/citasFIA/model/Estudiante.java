package edu.uam.citasFIA.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Icon;
import org.openxava.annotations.ListProperties;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@Getter
@Setter

public class Estudiante extends Identifiable {
    private String cif;
    private String nombrecompletoe;

    @ElementCollection
    @ListProperties("nombrecorreo")
    private Collection<Correo>correos;


}
