package com.example.nkenji.clothapp.model;

import com.example.nkenji.clothapp.viewmodel.Cloth;

import java.util.ArrayList;


public class SampleClothData {

    private static ArrayList<Cloth> mSampleList = new ArrayList<>();

    public SampleClothData() {
        mSampleList.clear();
        mSampleList.add(new Cloth("Tshirt", 1000, "20130502", Cloth.Genre.SHIRT));
        mSampleList.add(new Cloth("Pants", 2000, "20140602", Cloth.Genre.PANTS));
        mSampleList.add(new Cloth("Dress", 3000, "20150702", Cloth.Genre.DRESS));
        mSampleList.add(new Cloth("Tshirt", 4000, "20160802", Cloth.Genre.SHIRT));
    }

    public static ArrayList<Cloth> getDB(){
        return mSampleList;
    }
}
