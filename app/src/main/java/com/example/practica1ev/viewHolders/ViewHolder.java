package com.example.practica1ev.viewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView img;
    private TextView nombre;
    private TextView web;
    private TextView localizacion;
    private TextView mail;

    public ViewHolder(ImageView img,TextView nombre, TextView web, TextView localizacion, TextView mail) {
        this.nombre = nombre;
        this.web = web;
        this.localizacion = localizacion;
        this.mail = mail;
        this.img = img;
    }
    public TextView getWeb() {
        return web;
    }

    public void setWeb(TextView web) {
        this.web = web;
    }

    public TextView getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(TextView localizacion) {
        this.localizacion = localizacion;
    }

    public TextView getMail() {
        return mail;
    }

    public void setMail(TextView mail) {
        this.mail = mail;
    }


    public TextView getTv() {
        return nombre;
    }

    public void setTv(TextView nombre) {
        this.nombre = nombre;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

}
