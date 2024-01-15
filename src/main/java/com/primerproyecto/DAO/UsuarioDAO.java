package com.primerproyecto.DAO;

import com.primerproyecto.models.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> getUsuarios();
    public void eliminar(String id);
    public void registrar(Usuario usuario);
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
