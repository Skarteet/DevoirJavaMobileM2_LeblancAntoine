package com.ynov.devandroiddevoir.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.ynov.devandroiddevoir.R;

public class SearchFragment extends Fragment {

    public SearchFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button searchElement = getView().findViewById(R.id.searchComponent);
        searchElement.setOnClickListener(view1 ->
                Navigation.findNavController(getView()).navigate(R.id.list_city_navigation));

    }
}