package com.example.nkenji.clothapp.viewmodel;

import android.util.Log;
import android.view.View;

public class MainViewModel {

    public void onClickCloth(View view) {
        Log.e("Tag","Error");
    }

    public void showClothName(Cloth cloth) {
        System.out.println(cloth.getName());
    }
}
