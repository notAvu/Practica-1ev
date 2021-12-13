package com.example.practica1ev;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practica1ev.empresaClases.EmpresaTic;

public class DetallesVM extends ViewModel {
    MutableLiveData<EmpresaTic> empresa;

    public MutableLiveData<EmpresaTic> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(MutableLiveData<EmpresaTic> empresa) {
        this.empresa = empresa;
    }
}
