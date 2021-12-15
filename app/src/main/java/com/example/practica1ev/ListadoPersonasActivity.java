package com.example.practica1ev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.practica1ev.clasesPersona.Persona;
import com.example.practica1ev.empresaClases.EmpresaNormal;
import com.example.practica1ev.empresaClases.EmpresaTic;
import com.example.practica1ev.viewHolders.NewViewHolder;
import com.example.practica1ev.viewHolders.PersonasViewHolder;
import com.example.practica1ev.viewHolders.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListadoPersonasActivity extends AppCompatActivity {

    ArrayList<Persona> nombres;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_personas);
        spinner = findViewById(R.id.leSpinner);
        nombres = new ArrayList<>();
        nombres.add(new Persona("Alvaro", "606776629", "Incordio", "nomas@gmail.com"));
        nombres.add(new Persona("JoseMa", "606776629", "Profe", "nomas@gmail.com"));
        nombres.add(new Persona("Angel", "606776629", "Director", "nomas@gmail.com"));
        nombres.add(new Persona("Mar", "606776629", "FAQ", "nomas@gmail.com"));
        nombres.add(new Persona("Antonio", "606776629", "Sabio", "nomas@gmail.com"));
        spinner.setAdapter(new PersonasAdapter<>(this, R.layout.persona_cargo_layout, nombres));
    }

    public class PersonasAdapter<T> extends ArrayAdapter<T> {

        public PersonasAdapter(@NonNull Context context, int resource, @NonNull List<T> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = getLayoutInflater();
            PersonasViewHolder holder;
            if (row == null) {
                Persona persona = (Persona) getItem(position);
                row = inflater.inflate(R.layout.persona_cargo_layout, parent, false);
                holder = createViewHolder(row, persona);
            } else holder = (PersonasViewHolder) row.getTag();
            return (row);
        }

        private PersonasViewHolder createViewHolder(View row, Persona persona) {
            TextView nombre = row.findViewById(R.id.persona_cargo__tv__nombre);
            TextView cargo= row.findViewById(R.id.persona_cargo__tv__cargo);
            nombre.setText(persona.getNombre());
            cargo.setText(persona.getCargo());
            return new PersonasViewHolder (nombre, cargo);
        }
    }
}