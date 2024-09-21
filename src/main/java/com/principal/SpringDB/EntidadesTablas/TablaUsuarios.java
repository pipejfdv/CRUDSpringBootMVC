package com.principal.SpringDB.EntidadesTablas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
//quitar metodos get and set
@Data
//identificar que es una entidada
@Entity
//nombre de la tabla hace referencia
@Table(name = "usuarios")
public class TablaUsuarios {
    //mantener la compatibilidad con los elementos del remitente y receptor
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotNull(message = "no puede esta vacio el campo edad")
    private Integer edad;
    private String genero;
    @Email
    private String correo;

}
