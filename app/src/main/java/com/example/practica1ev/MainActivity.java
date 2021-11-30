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
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica1ev.empresaClases.Empresa;
import com.example.practica1ev.empresaClases.EmpresaNormal;
import com.example.practica1ev.empresaClases.EmpresaTic;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AutoCompleteTextView actv;
    Empresa[] listadoEmpresas = {
            new EmpresaTic(R.drawable.embeces, "EmpresaTic", "https//enlace_completamente_normal.com", "Calle melancolia 7", "empresaTic@gmail.com"),
            new EmpresaNormal(R.drawable.embeces, "EmpresaNormal", "055")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listado);
        actv.findViewById(R.id.barra);
    }

    public class ViewHolder {
        private ImageView img;
        private TextView nombre;
        private TextView web;
        private TextView localizacion;
        private TextView mail;

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

        public ViewHolder(TextView nombre, TextView web, TextView localizacion, TextView mail, ImageView img) {
            this.nombre = nombre;
            this.web = web;
            this.localizacion = localizacion;
            this.mail = mail;
            this.img = img;
        }
    }

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

    class MyAdapter<T> extends ArrayAdapter<T> {

        Context context;
        T[] objects;

        public MyAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
            super(context, resource, objects);
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            int i = 1;
            if (position == 2 || position == 3) i = 0;
            return i;
        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        {
//            View row = convertView;
//
//            LayoutInflater inflater=getLayoutInflater();
//
//
//            if(getItemViewType(position)==0)
//            {
//                ViewHolder holder;
//                if (row==null)
//                {
//                    row = inflater.inflate(R.layout.custom_list_layout, parent, false);
//                    TextView lab    = row.findViewById(R.id.list_item);
//                    ImageView imgV = row.findViewById(R.id.icon);
//                    holder=new ViewHolder(lab, imgV);
//
//                }else
//                {
//                    holder = (ViewHolder) row.getTag();
//                }
//            }else
//            {
//                NewViewHolder nvh;
//                if (row==null)
//                {
//                    row = inflater.inflate(R.layout.regular_layout, parent, false);
//                    TextView lab    = row.findViewById(R.id.list_item);
//                    ImageView imgV  = row.findViewById(R.id.icon);
//                    nvh=new NewViewHolder(lab,imgV,imgV2);
//                }else
//                {
//                    nvh = (NewViewHolder) row.getTag();
//                }
//            }
//
//            return(row);
            return null;
        }
    }
}