package com.example.practica1ev.empresaClases;

public class Empresa {
    private int imageId;
    private String text;

    public Empresa(int id, String txt)
    {
        this.imageId=id;
        this.text=txt;

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
