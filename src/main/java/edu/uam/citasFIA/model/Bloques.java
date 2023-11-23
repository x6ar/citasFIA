package edu.uam.citasFIA.model;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DateTime;
import org.openxava.annotations.ListProperties;
import org.openxava.model.Identifiable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
public class Bloques extends Identifiable {
    private String nombre;

    @DateTime
    private Date inicio;
    @DateTime
    private Date fin;

    @OneToMany(mappedBy = "bloques", cascade = CascadeType.REMOVE)
    @ListProperties("fecha,estudiante.nombrecompletoe,motivo.nombreMotivo,motivo.duracion,observaciones")
    Collection<Solicitud> solicitudes;
}
