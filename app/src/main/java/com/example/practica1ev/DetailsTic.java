package com.example.practica1ev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practica1ev.empresaClases.EmpresaTic;

public class DetailsTic extends AppCompatActivity implements View.OnClickListener {

    TextView web;
    ImageButton locationButton;
    EmpresaTic eie;
    TextView mail;
    TextView tv;
    ImageView logo;
    EditText tlfn;
    EditText direccion;

    private void initViews() {
        tv.setText(eie.getName());
        logo.setImageResource(eie.getImageId());
        mail.setText(eie.getMail());
        web.setText(eie.getWeb());
        direccion.setText(eie.getLocation());
    }

    private void findViews() {
        locationButton = findViewById(R.id.loc_button);
        logo = findViewById(R.id.logo);
        tv = findViewById(R.id.nombre_empresa);
        mail = findViewById(R.id.edit_mail);
        tlfn = findViewById(R.id.edit_tlfn);
        direccion = findViewById(R.id.edit_direccion);
        web = findViewById(R.id.web);
        eie = getIntent().getParcelableExtra("empresaurio");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_tic);
        findViews();
        initViews();
        locationButton.setOnClickListener(this);
        web.setOnClickListener(this);
        mail.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.web): {
                launchNavigator(eie.getWeb());
            }
            case (R.id.loc_button): {
                launchGoogleMaps();
            }
            case(R.id.edit_mail):{
                launchMail(eie.getMail());
            }
        }
    }

    private void launchMail(String mail) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,mail);
        startActivity(i);
    }

    private void launchNavigator(String url) {
        Intent i;
        Uri embeces = Uri.parse(url);
        i = new Intent(Intent.ACTION_VIEW, embeces);
        startActivity(i);
    }

    private void launchGoogleMaps() {
        Intent i;
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        i = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }
}