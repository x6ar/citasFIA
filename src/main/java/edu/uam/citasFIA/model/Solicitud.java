package edu.uam.citasFIA.model;


import edu.uam.citasFIA.calculadores.DefaultEstado;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

@Entity @Getter @Setter

public class Solicitud extends Identifiable {

   @ManyToOne
   private Motivo motivo;

 @ManyToOne(fetch = FetchType.LAZY)
 @DescriptionsList(descriptionProperties = "nombre")
   private Bloques bloques;

    @TextArea
    String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombrecompletoc")
    private Personal personal;

    @ReadOnly
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombrecompletoe")
    private Estudiante estudiante;

    @DefaultValueCalculator(CurrentDateCalculator.class)
    private Date fecha;



    @DefaultValueCalculator(value = DefaultEstado.class)
    private Integer estado;

    @Column(length = 2)
    Integer horas;

    @Column(length = 2)
    Integer minutos;

    @Depends("horas,minutos")
    public String getHoraInicio(){
     if (horas != null && minutos !=null) return String.valueOf(horas) + ":" + String.valueOf(minutos);
     return "";
 }
 @Depends("horas,minutos,motivo.duracion")
 public String getHoraFin(){
  if (horas != null && minutos !=null && motivo.getDuracion() != null) return String.valueOf(horas) + ":" + String.valueOf(minutos+ motivo.getDuracion());
  return "";
 }




}
