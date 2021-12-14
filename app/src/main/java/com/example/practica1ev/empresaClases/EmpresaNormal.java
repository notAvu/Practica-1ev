package com.example.practica1ev.empresaClases;

import android.os.Parcel;
import android.os.Parcelable;

public class EmpresaNormal extends Empresa implements Parcelable {

    private String cnae;

    public EmpresaNormal(int imageId, String txt, String cnae) {
        super(imageId, txt);
        this.cnae=cnae;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
