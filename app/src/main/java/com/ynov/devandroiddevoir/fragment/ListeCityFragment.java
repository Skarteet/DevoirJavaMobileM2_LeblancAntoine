package com.ynov.devandroiddevoir.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ynov.devandroiddevoir.R;
import com.ynov.devandroiddevoir.adapter.CityAdapter;
import com.ynov.devandroiddevoir.bo.City;
import com.ynov.devandroiddevoir.viewmodel.ListCityFragmentViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListeCityFragment extends Fragment {

    private static final String TAG = "ListeCityFragment";
    private RecyclerView rv;
    private CityAdapter adapter;
    private ListCityFragmentViewModel vm;
    OkHttpClient client;

    public ListeCityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ViewModelProvider(this).get(ListCityFragmentViewModel.class);
        client = new OkHttpClient();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liste_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initCities();

        Observer<ArrayList<City>> observerList = cities -> {
            adapter.setCityArrayList(cities);
        };

        vm.getArrayListCity().observe(getViewLifecycleOwner(),observerList);
        if(vm.getArrayListCity().getValue().isEmpty())
        {
            fetchCities();
        }
    }

    private void initCities(){
        rv = getView().findViewById(R.id.citiesRecyclerView);
        adapter = new CityAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }

    private void fetchCities(){
        Request request = new Request.Builder()
                .url("https://flutter-learning.mooo.com/villes")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + "récupération msgs:" + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.code() == 200){
                    ArrayList<City> cities = new Gson().fromJson(
                            response.body().string(),
                            new TypeToken<ArrayList<City>>(){}.getType()
                    );
                    vm.getArrayListCity().postValue(cities);
                }else{
                    Log.e(TAG, "onResponse: " + "not valid" );
                }
            }
        });
    }
}