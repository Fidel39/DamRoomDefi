package com.example.demo.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "cliente")
public class Cliente {

    @Schema(description = "Identificador del cliente", example = "48986654L", required = true)
    @Id
    private String dni;

    @Schema(description = "Nombre del cliente", example = "Bartolo", required = true)
    @NotBlank
    @Column
    private String nombre;

    @Schema(description = "Apellido del cliente", example = "Muñoz", required = true)
    @NotBlank
    @Column
    private String apellido;

    @Schema(description = "Direccion del cliente", example = "Calle Falsa numero 2", required = true)
    @NotBlank
    @Column
    private String direccion;

    @Schema(description = "Telefono del cliente", example = "236694365", required = true)
    @NotBlank
    @Column
    private int telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Reservas> reservasList;

    public Cliente(){
        dni = "";
        nombre = "";
        apellido = "";
        direccion = "";
        telefono = 0;
    }

    public Cliente(String dni, String nombre, String apellido, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", reservasList=" + reservasList +
                '}';
    }
}
