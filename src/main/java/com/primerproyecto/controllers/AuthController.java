package com.primerproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.primerproyecto.DAO.UsuarioDAO;
import com.primerproyecto.models.Usuario;
import com.primerproyecto.utils.JWTUtil;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private JWTUtil jwtUtil; 

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado=usuarioDAO.obtenerUsuarioPorCredenciales(usuario);

        if(usuarioLogueado!=null){
            String token=jwtUtil.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getEmail());

            return token;
        }
        return "FAILD";
    }
}
