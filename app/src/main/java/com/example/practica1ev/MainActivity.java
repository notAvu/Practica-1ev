package com.example.practica1ev;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1ev.empresaClases.Empresa;
import com.example.practica1ev.empresaClases.EmpresaNormal;
import com.example.practica1ev.empresaClases.EmpresaTic;
import com.example.practica1ev.viewHolders.NewViewHolder;
import com.example.practica1ev.viewHolders.ViewHolder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    AutoCompleteTextView autoCompleteTv;
    LinkedList<Empresa> listadoEmpresa = new LinkedList<>();
    MyAdapter<Empresa> adaptateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTv = findViewById(R.id.barra);
        lv = findViewById(R.id.listado);
        listadoEmpresa.add(new EmpresaTic(R.drawable.aperture, "Aperture Science", "https://es.wikipedia.org/wiki/Aperture_Science", "En un pozo", "apertureLabs@gladOs.com"));
        listadoEmpresa.add(new EmpresaNormal(R.drawable.mishima, "Mishima corp", "8559"));
        listadoEmpresa.add(new EmpresaTic(R.drawable.oscorp, "Oscorp", "https://www.oscorp-industries.com/", "Avda de la plata 23", "empresaFalsa@gmail.com"));
        listadoEmpresa.add(new EmpresaNormal(R.drawable.saboresdelatierra, "Sabores de la tierra", "6024"));
        listadoEmpresa.add(new EmpresaNormal(R.drawable.embeces, "Esta Empresa", "6024"));
        adaptateur = new MyAdapter<>(this, R.layout.regular_layout, listadoEmpresa);
        lv.setAdapter(adaptateur);
        autoCompleteTv.setAdapter(adaptateur);
        autoCompleteTv.addTextChangedListener(new MyTextWatcher(adaptateur));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, DetailsTic.class);
        if (adaptateur.empresasFiltradas.get(position) instanceof EmpresaTic) {
            i.putExtra("empresaurio", adaptateur.empresasFiltradas.get(position));
            startActivity(i);
        }
    }

    public class MyAdapter<T> extends ArrayAdapter<T> {

        LinkedList<T> listaCompleta;
        LinkedList<T> empresasFiltradas;
        private ItemFilter filter = new ItemFilter();

        public MyAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
            super(context, resource, objects);
            listaCompleta = new LinkedList<>();
            empresasFiltradas = new LinkedList<>();
            listaCompleta.addAll(Arrays.asList(objects));
            empresasFiltradas.addAll(Arrays.asList(objects));
        }

        public MyAdapter(@NonNull Context context, int resource, @NonNull List<T> objects) {
            super(context, resource, objects);
            listaCompleta = new LinkedList<>();
            empresasFiltradas = new LinkedList<>();
            listaCompleta.addAll(objects);
            empresasFiltradas.addAll(objects);
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getCount() {
            return empresasFiltradas.size();
        }


        @Override
        public int getItemViewType(int position) {
            return empresasFiltradas.get(position) instanceof EmpresaTic ? 1 : 0;
        }

        @Override
        public T getItem(int position) {
            return empresasFiltradas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = getLayoutInflater();

            if (getItemViewType(position) == 1) {
                ViewHolder holder;
                if (row == null) {
                    row = inflater.inflate(R.layout.tic_layout, parent, false);
                } else holder = (ViewHolder) row.getTag();
                EmpresaTic empresaTic = (EmpresaTic) getItem(position);
                holder = createViewHolder(row, empresaTic);
            } else if (getItemViewType(position) == 0) {
                NewViewHolder nvh;
                if (row == null) {
                    row = inflater.inflate(R.layout.regular_layout, parent, false);
                } else nvh = (NewViewHolder) row.getTag();
                EmpresaNormal empresaNormal = (EmpresaNormal) getItem(position);
                nvh = createNewViewHolder(row, empresaNormal);
            }
            return (row);
        }

        private NewViewHolder createNewViewHolder(View row, EmpresaNormal empresaNormal) {
            NewViewHolder nvh;
            TextView nombre = row.findViewById(R.id.nombre_tv);
            ImageView logo = row.findViewById(R.id.logo);
            TextView cnae = row.findViewById(R.id.cnae_code);
            nombre.setText(empresaNormal.getName());
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
            nombre.setText(empresaTic.getName());
            web.setText(empresaTic.getWeb());
            direccion.setText(empresaTic.getLocation());
            mail.setText(empresaTic.getMail());
            logo.setImageResource(empresaTic.getImageId());
            return new ViewHolder(logo, nombre, web, direccion, mail);
        }

        private class ItemFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterString = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();
                LinkedList<Empresa> tempItems = new LinkedList<>();

                for (int i = 0; i < listadoEmpresa.size(); i++) {
                    if (listadoEmpresa.get(i).getName().toLowerCase().contains(filterString)) {
                        tempItems.add(listadoEmpresa.get(i));
                    }
                }
                results.values = tempItems;
                results.count = tempItems.size();
                return results;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                empresasFiltradas = (LinkedList<T>) results.values;
                notifyDataSetChanged();
            }
        }

        @Override
        public Filter getFilter() {
            return this.filter;
        }

    }

    class MyTextWatcher implements TextWatcher {
        private MyAdapter<Empresa> lAdapter;

        public MyTextWatcher(MyAdapter<Empresa> lAdapter) {
            this.lAdapter = lAdapter;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            lAdapter.getFilter().filter(s.toString().toLowerCase());
        }
    }
}
