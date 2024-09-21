package com.principal.SpringDB.Controlador;



import com.principal.SpringDB.EntidadesTablas.TablaUsuarios;
import com.principal.SpringDB.ServiciosUsoSQL.ServiciosUsuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {
    @Autowired
    private ServiciosUsuarios serviciosUsuarios;
    @GetMapping("/prueba")
    public String prueba(Model model) {
        List<TablaUsuarios> usuarios = serviciosUsuarios.lista();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }
    //redirigir
    @GetMapping("/agregar")
    public String agregar(Model model) {
        return "registro";
    }
    //metodo para guardar al usuario
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("usuario") TablaUsuarios usuario, Errors errors) {
        if (errors.hasErrors()) return "registro";
        serviciosUsuarios.crearActualizar(usuario);
        return "redirect:/prueba";
    }
    //metodo para llamar los datos del usuario y actualizar
    @GetMapping("/cambiar/{id}")
    public String cambiar(Model model, @PathVariable int id) {
        Optional<TablaUsuarios> tablaUsuarios = serviciosUsuarios.usuario(id);
        //como es una lista se necesita validar
        if (tablaUsuarios.isPresent()) {
            model.addAttribute("tablaUsuarios", tablaUsuarios.get());
        }
        else {
            model.addAttribute("error", "Usuario no encontrado");
        }
        return "actualizar";
    }
    //borrar usuario
    @GetMapping("/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        serviciosUsuarios.eliminar(id);
        return "redirect:/prueba";
    }
}
