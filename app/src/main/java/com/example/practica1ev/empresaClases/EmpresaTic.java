package com.example.practica1ev.empresaClases;

import android.os.Parcel;
import android.os.Parcelable;

public class EmpresaTic extends Empresa implements Parcelable {
    private String web;
    private String location;
    private String mail;

    public EmpresaTic(int id, String txt,String web,String location, String mail)
    {
        super(id,txt);
        this.mail=mail;
        this.web=web;
        this.location=location;
    }

    protected EmpresaTic(Parcel in) {
        super();
        setImageId(in.readInt());
        setName(in.readString());
        web = in.readString();
        location = in.readString();
        mail = in.readString();
    }

    public static final Creator<EmpresaTic> CREATOR = new Creator<EmpresaTic>() {
        @Override
        public EmpresaTic createFromParcel(Parcel in) {
            return new EmpresaTic(in);
        }

        @Override
        public EmpresaTic[] newArray(int size) {
            return new EmpresaTic[size];
        }
    };

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getImageId());
        dest.writeString(getName());
        dest.writeString(web);
        dest.writeString(location);
        dest.writeString(mail);
    }
}
