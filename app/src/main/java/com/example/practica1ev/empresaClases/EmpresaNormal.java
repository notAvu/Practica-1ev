package com.example.practica1ev.empresaClases;

public class EmpresaNormal extends Empresa{

    private String cnae;
    private String actividad;

    public EmpresaNormal(int imageId, String txt, String actividad, String cnae) {
        super(imageId, txt);
        this.actividad=actividad;
        this.cnae=cnae;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

}
