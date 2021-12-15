package com.example.practica1ev.viewHolders;

import android.widget.TextView;

public class PersonasViewHolder {
    TextView nombre;
    TextView cargo;

    public PersonasViewHolder(TextView nombre, TextView cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }
    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getCargo() {
        return cargo;
    }

    public void setCargo(TextView cargo) {
        this.cargo = cargo;
    }

}
