package com.primerproyecto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Column(name="ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Apellido")
    private String apellido;

    @Column(name="Email")
    private String email;

    @Column(name="Telefono")
    private String telefono;

    @Column(name="Password")
    private String password;

    public Usuario(){

    }

    public void setId(String id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getPassword(){
        return this.password;
    }

    public String getId(){
        return this.id;
    }
}
