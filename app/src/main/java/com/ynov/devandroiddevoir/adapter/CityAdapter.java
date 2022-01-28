package com.ynov.devandroiddevoir.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.ynov.devandroiddevoir.R;
import com.ynov.devandroiddevoir.bo.Accommodation;
import com.ynov.devandroiddevoir.bo.City;
import com.ynov.devandroiddevoir.databinding.RowLayoutCityBinding;
import com.ynov.devandroiddevoir.activity.DetailLogementActivity;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CityAdapter extends RecyclerView.Adapter<CityHolder> {

    private static final String TAG = "CityAdapter";
    ArrayList<City> listCity;

    public CityAdapter(){
        listCity = new ArrayList<>();
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutCityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_city,
                parent,
                false
        );
        return new CityHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        City city =listCity.get(position);
        ImageView iv =holder.itemView.findViewById(R.id.imageView);
        holder.binding.setCity(city);
        Picasso.get().load("https://flutter-learning.mooo.com"+city.getPic().getUrl()).
                resize(50,50).into(iv);

        holder.itemView.setOnClickListener(view ->
                onClick(holder,city));
    }

    @Override
    public int getItemCount() {
        return listCity.size();
    }

    public void setCityArrayList(ArrayList<City> cityArrayList){
        this.listCity = cityArrayList;
        notifyDataSetChanged();
    }

    private void onClick(CityHolder holder, City city){

        Request request = new Request.Builder()
                .url("https://flutter-learning.mooo.com/logements?place.id="+city.getId())
                .build();

        OkHttpClient client = new OkHttpClient();
;
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + "récupération msgs:" + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.code() == 200){
                    ArrayList<Accommodation> accommodations = new Gson().fromJson(
                            response.body().string(),
                            new TypeToken<ArrayList<Accommodation>>(){}.getType()
                    );
                    if(accommodations.isEmpty())
                    {
                        Snackbar.make(holder.itemView,"Aucun logement pour cette ville",Snackbar.LENGTH_LONG).show();

                    }else{

                        Intent intentToDetail =new Intent(holder.itemView.getContext(), DetailLogementActivity.class);
                        intentToDetail.putExtra("logement",accommodations.get(0));
                        holder.itemView.getContext().startActivity(intentToDetail);
                    }
                }else{
                    Log.e(TAG, "onResponse: " + "not valid" );
                }
            }
        });

    }
}
