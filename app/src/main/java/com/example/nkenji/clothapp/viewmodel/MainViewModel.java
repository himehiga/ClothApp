package com.example.nkenji.clothapp.viewmodel;

import com.example.nkenji.clothapp.model.SampleClothData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class MainViewModel {

    public String firstName;
    private int count;

    private List<Cloth> mMyClothList = new ArrayList<>();

    public MainViewModel(){

    }

    public List<Cloth> getDB(){
      return new SampleClothData().getDB();
    }

    public List<Cloth> getSelectedItems(Cloth.Genre genre) {

        //ListをRxでfilterした結果を返す
        List<Cloth> clothItems = new SampleClothData().getDB();
        return Flowable.fromIterable(clothItems)
                .filter(cloth -> cloth.getGenre() == genre)
                .toList().blockingGet();
    }
}
