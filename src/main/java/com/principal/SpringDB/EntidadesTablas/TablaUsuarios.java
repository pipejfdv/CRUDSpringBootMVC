package com.principal.SpringDB.EntidadesTablas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "no puede esta vacio desde ENTIDAD")
    private String nombre;
    @NotNull
    private Integer edad;
    @NotEmpty
    private String genero;
    @NotEmpty
    @Email
    private String correo;

}
