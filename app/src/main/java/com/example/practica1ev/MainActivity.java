package com.example.practica1ev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1ev.empresaClases.Empresa;
import com.example.practica1ev.empresaClases.EmpresaNormal;
import com.example.practica1ev.empresaClases.EmpresaTic;
import com.example.practica1ev.viewHolders.NewViewHolder;
import com.example.practica1ev.viewHolders.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    AutoCompleteTextView actv;
    ArrayList<Empresa> arrayListEmpresa= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = findViewById(R.id.barra);
        lv = findViewById(R.id.listado);
        arrayListEmpresa.add(new EmpresaTic(R.drawable.aperture, "Aperture Science", "https//enlace_completamente_normal.com", "En un pozo", "apertureLabs@gladOs.com"));
        arrayListEmpresa.add(new EmpresaNormal(R.drawable.mishima, "Mishima corp", "8559"));
        arrayListEmpresa.add( new EmpresaTic(R.drawable.oscorp, "Oscorp", "https//estafa_piramidal.com", "Avda de la plata 23", "empresaFalsa@gmail.com"));
        arrayListEmpresa.add(new EmpresaNormal(R.drawable.embeces, "LaotraEmpresa", "6024"));
        arrayListEmpresa.add(new EmpresaNormal(R.drawable.embeces, "Esta Empresa", "6024"));
        MyAdapter<Empresa> adaptateur = new MyAdapter<>(this, R.layout.regular_layout, arrayListEmpresa);
        lv.setAdapter(adaptateur);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(MainActivity.this, DetailsTic.class);
        startActivity(i);    }

    public class MyAdapter<T> extends ArrayAdapter<T> {

        public MyAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
            super(context, resource, objects);
        }
        public MyAdapter(@NonNull Context context, int resource, @NonNull List<T> objects){
            super(context, resource, objects);
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return getItem(position) instanceof EmpresaTic ? 1 : 0;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = getLayoutInflater();

            if (getItemViewType(position) == 1) {
                ViewHolder holder;
                if (row == null) {
                    EmpresaTic empresaTic = (EmpresaTic) getItem(position);
                    row = inflater.inflate(R.layout.tic_layout, parent, false);
                    holder = createViewHolder(row, empresaTic);

                } else holder = (ViewHolder) row.getTag();
            } else if (getItemViewType(position) == 0) {
                NewViewHolder nvh;
                if (row == null) {
                    EmpresaNormal empresaNormal = (EmpresaNormal) getItem(position);
                    row = inflater.inflate(R.layout.regular_layout, parent, false);
                    nvh = createNewViewHolder(row, empresaNormal);
                } else nvh = (NewViewHolder) row.getTag();
            }
            return (row);
        }

        private NewViewHolder createNewViewHolder(View row, EmpresaNormal empresaNormal) {
            NewViewHolder nvh;
            TextView nombre = row.findViewById(R.id.nombre_tv);
            ImageView logo = row.findViewById(R.id.logo);
            TextView cnae = row.findViewById(R.id.cnae_code);
            nombre.setText(empresaNormal.getText());
            logo.setImageResource(empresaNormal.getImageId());
            cnae.setText(empresaNormal.getCnae());
            return new NewViewHolder(logo, nombre, cnae);
        }

        private ViewHolder createViewHolder(View row, EmpresaTic empresaTic) {
            TextView nombre = row.findViewById(R.id.nombre_tv);
            TextView web = row.findViewById(R.id.link_tv);
            TextView direccion = row.findViewById(R.id.location_tv);
            TextView mail = row.findViewById(R.id.mail_tv);
            ImageView logo = row.findViewById(R.id.logo);
            nombre.setText(empresaTic.getText());
            web.setText(empresaTic.getWeb());
            direccion.setText(empresaTic.getLocation());
            mail.setText(empresaTic.getMail());
            logo.setImageResource(empresaTic.getImageId());
            return new ViewHolder(logo, nombre, web, direccion, mail);
        }
    }
}