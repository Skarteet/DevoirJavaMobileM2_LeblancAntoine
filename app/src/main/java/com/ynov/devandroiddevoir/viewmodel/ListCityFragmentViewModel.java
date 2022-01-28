package com.ynov.devandroiddevoir.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ynov.devandroiddevoir.bo.City;

import java.util.ArrayList;

public class ListCityFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<City>> arrayListCity;

    public MutableLiveData<ArrayList<City>> getArrayListCity(){
        if(arrayListCity == null){
            this.arrayListCity = new MutableLiveData<>(new ArrayList<>());
        }
        return this.arrayListCity;
    }

}
