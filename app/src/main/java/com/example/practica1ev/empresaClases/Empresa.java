package com.example.practica1ev.empresaClases;

import android.os.Parcelable;

public abstract class Empresa implements Parcelable {
    private int imageId;
    private String name;

    public Empresa(int id, String txt)
    {
        this.imageId=id;
        this.name =txt;

    }

    public Empresa() {

    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
