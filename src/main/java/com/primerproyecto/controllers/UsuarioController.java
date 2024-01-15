package com.primerproyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.primerproyecto.DAO.UsuarioDAO;
import com.primerproyecto.models.Usuario;
import com.primerproyecto.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value = "api/usuarios/{id}",method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable String id){
        Usuario usuario=new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@gmail.com");
        usuario.setTelefono("2132132151");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if(!this.validarToken(token)){
            return null;
        }

        return usuarioDAO.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioID=jwtUtil.getKey(token);

        return usuarioID!=null;
    }

    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrar(@RequestBody Usuario usuario){
        Argon2 argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash=argon2.hash(1, 1024, 1, usuario.getPassword());

        usuario.setPassword(hash);

        usuarioDAO.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable String id,@RequestHeader(value = "Authorization") String token){
        if(!this.validarToken(token)){
            return;
        }
        
        usuarioDAO.eliminar(id);
    }
}
