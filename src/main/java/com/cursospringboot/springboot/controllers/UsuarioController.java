package com.cursospringboot.springboot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.cursospringboot.springboot.models.UsuarioModel;
import com.cursospringboot.springboot.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path="/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok=this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el Usuario "+id+" con exito";
        }
        return "No se pudo eliminar el usuario " + id;

    }
    
}
