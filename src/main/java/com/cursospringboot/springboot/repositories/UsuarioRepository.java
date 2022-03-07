package com.cursospringboot.springboot.repositories;

import java.util.ArrayList;

import com.cursospringboot.springboot.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{

    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    
}
