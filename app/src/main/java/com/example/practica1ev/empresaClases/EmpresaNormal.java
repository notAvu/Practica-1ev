package com.example.practica1ev.empresaClases;

public class EmpresaNormal extends Empresa{

    private String cnae;

    public EmpresaNormal(int imageId, String txt, String cnae) {
        super(imageId, txt);
        this.cnae=cnae;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }
}
