package com.example.demo.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "habitaciones")
public class Habitacion {


    @Schema(description = "Identificador de la habitacion", example = "1",
            required = true)
    @Id
    private long NumeroHabitacion;

    @Schema(description = "Tipo de la habitacion", example = "Presidencial",
            required = true)
    @Column
    private String Tipo;


    @Schema(description = "Caracteristicas de la habitacion", example = "Dos camas con una television  y un baño",
            required = true)
    @Column
    private String Caracteristicas;


    @Schema(description = "Precio  de la habitacion", example = "450€",
            required = true)
    @NotBlank
    @Column
    private Float ImporteNoche;

    public Habitacion(long numeroHabitacion, String tipo, String caracteristicas, Float importeNoche, Reservas reserva) {
        NumeroHabitacion = numeroHabitacion;
        Tipo = tipo;
        Caracteristicas = caracteristicas;
        ImporteNoche = importeNoche;
        this.reserva = reserva;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservas reserva;

    public long getNumeroHabitacion() {
        return NumeroHabitacion;
    }

    public void setNumeroHabitacion(long numeroHabitacion) {
        NumeroHabitacion = numeroHabitacion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public Float getImporteNoche() {
        return ImporteNoche;
    }

    public void setImporteNoche(Float importeNoche) {
        ImporteNoche = importeNoche;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "NumeroHabitacion=" + NumeroHabitacion +
                ", Tipo='" + Tipo + '\'' +
                ", Caracteristicas='" + Caracteristicas + '\'' +
                ", ImporteNoche=" + ImporteNoche +
                ", reserva=" + reserva +
                '}';
    }
}
