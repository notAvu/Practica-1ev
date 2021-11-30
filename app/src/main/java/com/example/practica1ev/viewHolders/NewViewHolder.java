package com.example.practica1ev.viewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class NewViewHolder {
    private ImageView img;
    private TextView nombre;
    private TextView cnae;

    public NewViewHolder(ImageView img, TextView nombre, TextView cnae) {
        this.img = img;
        this.nombre = nombre;
        this.cnae = cnae;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getCnae() {
        return cnae;
    }

    public void setCnae(TextView cnae) {
        this.cnae = cnae;
    }
}
