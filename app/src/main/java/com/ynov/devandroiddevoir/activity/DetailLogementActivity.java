package com.ynov.devandroiddevoir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ynov.devandroiddevoir.R;
import com.ynov.devandroiddevoir.bo.Accommodation;
import com.ynov.devandroiddevoir.bo.ImageBnb;
import com.ynov.devandroiddevoir.databinding.ActivityDetailLogementBinding;

public class DetailLogementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logement);

        ActivityDetailLogementBinding binding = DataBindingUtil.setContentView(
                this,R.layout.activity_detail_logement
        );

        Accommodation logement = (Accommodation) getIntent().getSerializableExtra("logement");
        binding.setAccommodation(logement);

        ImageView iv = findViewById(R.id.logementPicture);

        Picasso.get().load("https://flutter-learning.mooo.com"+logement.getIllustrations().getUrl()).
                into(iv);

    }
}