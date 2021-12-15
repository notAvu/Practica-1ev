package com.example.practica1ev;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practica1ev.empresaClases.EmpresaTic;

public class DetallesVM extends ViewModel {

    MutableLiveData<EmpresaTic> ticMutableLiveData;

    public DetallesVM(EmpresaTic ticMutableLiveData) {
        this.ticMutableLiveData= new MutableLiveData<>();
        this.ticMutableLiveData.postValue(ticMutableLiveData);
    }

    public MutableLiveData<EmpresaTic> getTicMutableLiveData() {
        if (ticMutableLiveData == null){
            ticMutableLiveData = new MutableLiveData<>();
        }
        return ticMutableLiveData;
    }

    public void setTicMutableLiveData(MutableLiveData<EmpresaTic> ticMutableLiveData) {
        this.ticMutableLiveData = ticMutableLiveData;
    }

}
