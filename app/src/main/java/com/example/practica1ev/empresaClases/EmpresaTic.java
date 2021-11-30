package com.example.practica1ev.empresaClases;

public class EmpresaTic extends Empresa {
    private String web;
    private String location;
    private String mail;

    public EmpresaTic(int id, String txt,String web,String location, String mail)
    {
        super(id,txt);
        this.mail=mail;
        this.web=web;
        this.location=location;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
