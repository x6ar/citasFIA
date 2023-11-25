package edu.uam.citasFIA.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.ReadOnly;
import org.openxava.annotations.TextArea;
import org.openxava.model.Identifiable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Motivo extends Identifiable {
    private String nombreMotivo;
    private Integer duracion;
    @ReadOnly
    @OneToMany(mappedBy = "motivo", cascade = CascadeType.REMOVE)
    @ListProperties("fecha,estudiante.nombrecompletoe,motivo.nombreMotivo,motivo.duracion,observaciones")
    Collection<Solicitud> solicitudes;

    @TextArea
    private String descripmot;
}
