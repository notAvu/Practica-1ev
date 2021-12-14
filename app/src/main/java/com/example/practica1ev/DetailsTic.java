package com.example.practica1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practica1ev.empresaClases.EmpresaTic;

public class DetailsTic extends AppCompatActivity implements View.OnClickListener {

    TextView web;
    Button locationButton;
    EmpresaTic eie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_tic);
        locationButton= findViewById(R.id.loc_button);
        ImageView logo = findViewById(R.id.logo);
        TextView tv = findViewById(R.id.nombre_empresa);
        EditText mail = findViewById(R.id.edit_mail);
        EditText tlfn = findViewById(R.id.edit_tlfn);
        EditText direccion = findViewById(R.id.edit_direccion);
        web = findViewById(R.id.web);
        eie = getIntent().getParcelableExtra("empresaurio");
        tv.setText(eie.getName());
        logo.setImageResource(eie.getImageId());
        mail.setText(eie.getMail());
        web.setText(eie.getWeb());
        locationButton.setOnClickListener(this);
        web.setOnClickListener(this);
        direccion.setText(eie.getLocation());
    }

    @Override
    public void onClick(View v) {
        Intent i;
        if (v.equals(locationButton)) {
            launchGoogleMaps();
        } else {
            launchNavigator(eie.getWeb());
        }
    }

    private void launchNavigator(String url) {
        Intent i;
        Uri embeces=Uri.parse(url);
        i=new Intent(Intent.ACTION_VIEW, embeces);
        startActivity(i);
    }

    private void launchGoogleMaps() {
        Intent i;
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        i = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        i.setPackage("com.google.android.apps.maps");
//            if (i.resolveActivity(getPackageManager()) != null) {
        startActivity(i);
//            }
    }
}
//    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
//    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//mapIntent.setPackage("com.google.android.apps.maps");
//        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//        startActivity(mapIntent);
//        }