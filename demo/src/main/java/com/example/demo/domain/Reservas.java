package com.example.demo.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@Entity(name ="reservas")
public class Reservas {

    @Schema(description = "Identificador de la reserva", example = "1",
            required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codReserva;

    @Schema(description = "Fecha de inicio de la reserva", example = "12/01/2022",
            required = true)
    @NotBlank
    @Column
    private Date FechaIni;


    @Schema(description = "Fecha de finalizacion de la reserva", example = "12/01/2022",
            required = true)
    @NotBlank
    @Column
    private Date FechaFin;

    @Schema(description = "Precio  de la reserva", example = "450€",
            required = true)
    @NotBlank
    @Column
    private Float importe;

    @Schema(description = "Check In de la reserva", example = "12/01/2022",
            required = true)
    @NotBlank
    @Column
    private Boolean CheckIn;

    @Schema(description = "Check Out de la reserva", example = "12/01/2022",
            required = true)
    @NotBlank
    @Column
    private Boolean CheckOut;


    public Reservas(Date fechaIni, Date fechaFin, Float importe, Boolean checkIn, Boolean checkOut, Cliente cliente) {
        FechaIni = fechaIni;
        FechaFin = fechaFin;
        this.importe = importe;
        CheckIn = checkIn;
        CheckOut = checkOut;
        this.cliente = cliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public Date getFechaIni() {
        return FechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        FechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Boolean getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Boolean checkIn) {
        CheckIn = checkIn;
    }

    public Boolean getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(Boolean checkOut) {
        CheckOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "codReserva=" + codReserva +
                ", FechaIni=" + FechaIni +
                ", FechaFin=" + FechaFin +
                ", importe=" + importe +
                ", CheckIn=" + CheckIn +
                ", CheckOut=" + CheckOut +
                ", cliente=" + cliente +
                '}';
    }
}
