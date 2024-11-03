package com.principal.SpringDB.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//se busca encriptar las contraseñas
public class EncriptarContraseña {

    public static void main(String[] args) {
        String contrasena = "1234";
        System.out.println("contraseña actual: " + contrasena);
        System.out.println("contraseña encriptada: " + encriptar(contrasena));
    }

    public static String encriptar(String contrasena) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(contrasena);
    }
}
