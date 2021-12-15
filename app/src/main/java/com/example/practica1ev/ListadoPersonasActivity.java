package com.example.practica1ev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class ListadoPersonasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<Persona> nombres;
    Spinner spinner;
    TextView nombreTv;
    TextView cargoTv;
    TextView telefonoTv;
    TextView mailTv;

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
        nombreTv = findViewById(R.id.listado_personas__nombre);
        cargoTv = findViewById(R.id.listado_personas__cargo);
        telefonoTv = findViewById(R.id.listado_personas__tlfn);
        mailTv = findViewById(R.id.listado_personas__mail);
        PersonasAdapter<Persona> adapter = new PersonasAdapter<>(ListadoPersonasActivity.this, R.layout.persona_cargo_layout, nombres);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Persona select = nombres.get(i);
        nombreTv.setText(select.getNombre());
        cargoTv.setText(select.getCargo());
        telefonoTv.setText(select.getTelefono());
        mailTv.setText(select.getMail());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class PersonasAdapter<T> extends ArrayAdapter<T> {

        public PersonasAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
            super(context, resource, objects);
        }

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
                row.setTag(holder);
            } else {
                holder = (PersonasViewHolder) row.getTag();
            }
            return row;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = getLayoutInflater();
            PersonasViewHolder holder;
            if (row == null) {
                Persona persona = (Persona) getItem(position);
                row = inflater.inflate(R.layout.persona_cargo_layout, parent, false);
                holder = createViewHolder(row, persona);
                row.setTag(holder);
            } else {
                holder = (PersonasViewHolder) row.getTag();
            }
            return row;
        }

        private PersonasViewHolder createViewHolder(View row, Persona persona) {
            TextView nombre = row.findViewById(R.id.persona_cargo__tv__nombre);
            TextView cargo = row.findViewById(R.id.persona_cargo__tv__cargo);
            nombre.setText(persona.getNombre());
            cargo.setText(persona.getCargo());
            return new PersonasViewHolder(nombre, cargo);
        }
    }
}