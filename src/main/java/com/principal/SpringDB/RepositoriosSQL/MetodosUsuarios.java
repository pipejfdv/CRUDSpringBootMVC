package com.principal.SpringDB.RepositoriosSQL;

import com.principal.SpringDB.EntidadesTablas.TablaUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interfaz-Repository para la metodos usuarios SQL
@Repository
public interface MetodosUsuarios extends JpaRepository<TablaUsuarios, Integer> {

}
