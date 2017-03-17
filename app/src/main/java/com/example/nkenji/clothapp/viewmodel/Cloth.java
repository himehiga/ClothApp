package com.example.nkenji.clothapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.nkenji.clothapp.BR;

public class Cloth extends BaseObservable {
    public String name;
    private Integer price;

    public Cloth(String name){
        this.name = name;
    }

    @Bindable
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
