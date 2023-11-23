package edu.uam.citasFIA.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Icon;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.ReadOnly;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Personal extends Identifiable {
    private String cif;

    private String nombrecompletoc;


    @ElementCollection
    @ListProperties("nombrecorreo")
    private Collection<Correo>correos;

    @ReadOnly
    @OneToMany(mappedBy = "personal", cascade = CascadeType.REMOVE)
    @ListProperties("fecha,estudiante.nombrecompletoe,motivo.nombreMotivo,motivo.duracion,observaciones")
    Collection<Solicitud> solicitudes;

}
