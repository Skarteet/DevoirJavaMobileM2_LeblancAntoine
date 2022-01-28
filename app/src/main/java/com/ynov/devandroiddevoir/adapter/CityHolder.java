package com.ynov.devandroiddevoir.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.devandroiddevoir.databinding.RowLayoutCityBinding;

public class CityHolder extends RecyclerView.ViewHolder {

    RowLayoutCityBinding binding;

    public CityHolder(@NonNull RowLayoutCityBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }
}
