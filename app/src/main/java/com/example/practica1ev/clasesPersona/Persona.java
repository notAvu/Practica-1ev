package com.example.practica1ev.clasesPersona;

public class Persona {
    String nombre;
    String telefono;
    String cargo;
    String mail;

    public Persona(String nombre, String telefono, String cargo, String mail) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cargo = cargo;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
