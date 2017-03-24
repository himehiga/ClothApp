package com.example.nkenji.clothapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.nkenji.clothapp.BR;

public class Cloth extends BaseObservable{
    public enum Genre {
        SHIRT,
        DRESS,
        PANTS,
    }

    private String name;
    private Integer price;
    private String date;
    private Cloth.Genre genre;

    public Cloth(String name, Integer price, String date, Cloth.Genre genre){
        this.name = name;
        this.price = price;
        this.date = date;
        this.genre = genre;
    }

    @Bindable
    public String getName() {
        return this.name;
    }

    @Bindable
    public Integer getPrice() {
        return this.price;
    }

    @Bindable
    public String getDate(){
        return this.getDate();
    }

    public Genre getGenre() {
        return this.genre;
    }

    //memo
    //・BRが読み込めない→自分のパッケージのBRを読み込む必要がある
    //・BRは@Bindableアノテーションをつけた変数に対し、コンパイル時に生成される
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.cloth);
    }
}
