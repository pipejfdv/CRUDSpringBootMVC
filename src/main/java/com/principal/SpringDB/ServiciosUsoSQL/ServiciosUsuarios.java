package com.principal.SpringDB.ServiciosUsoSQL;

import com.principal.SpringDB.EntidadesTablas.TablaUsuarios;
import com.principal.SpringDB.RepositoriosSQL.MetodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//identificar que es una clase servicios
@Service
public class ServiciosUsuarios {
    //invocar repositorio de usuarios
    @Autowired
    private MetodosUsuarios metodosUsuarios;

    //metodo para invocar todos los datos de la tabla
    public List<TablaUsuarios> lista(){
        return metodosUsuarios.findAll();
   }

    //metodo para buscar un usuario en especifico
    public Optional<TablaUsuarios> usuario(int id){
        return metodosUsuarios.findById(id);
    }

    //metodo crear y actualizar registro
    public void crearActualizar(TablaUsuarios usuario){
        metodosUsuarios.save(usuario);
    }
    public void eliminar(int id){
        metodosUsuarios.deleteById(id);
    }
}
