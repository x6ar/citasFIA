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

@View(members = "motivo;observaciones;personal;estudiante;fecha;" +
        "horas,minutos;horaInicio,horaFin;estado;archivos")
public class Solicitud extends Identifiable {

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "descripmot")
   private Motivo motivo;


/*
Observaciones. Hasta el final y poner place holder:
Indique alguna otra observación adicional que se debería tener en cuenta
para la cita con el Coordinador o Coordinadora
 */
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

 /*

INGRESAR ... DE LA CITA
horas : (LABEL) minutos MINUTOS (LABEL)

VIEW HORA FIN
LA CITA SE LLEVARA A CABO A LAS horaINICIO y finalizaria a las horaFIN
el día: fecha

*/
    @Column(length = 2)
    Integer horas;

    @Column(length = 2)
    Integer minutos;

    @Depends("horas,minutos")
    @Column(length = 5)
    public String getHoraInicio(){
     if (horas != null && minutos !=null&& minutos>9) return String.valueOf(horas) + ":" + String.valueOf(minutos);
     if(horas != null && minutos !=null&& minutos<=9) return String.valueOf(horas) + ":0" + String.valueOf(minutos);
     return "";
 }

 @Depends("horas,minutos,motivo.duracion")
 @Column(length = 5)
 public String getHoraFin() {
  if (horas != null && minutos != null && motivo.getDuracion() != null) {
   Integer totalMinutos = (horas * 60) + minutos + motivo.getDuracion();

   Integer nuevasHoras = totalMinutos / 60;
   Integer nuevosMinutos = totalMinutos % 60;

   return String.valueOf(nuevasHoras) + ":" + String.valueOf(nuevosMinutos);
  }
  return "";
 }

 @Files
 String archivos;

}
