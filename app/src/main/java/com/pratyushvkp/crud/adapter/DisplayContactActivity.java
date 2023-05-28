package com.pratyushvkp.crud.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.pratyushvkp.crud.R;

public class DisplayContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String name = intent.getStringExtra("RName");
        String phone = intent.getStringExtra("Rphone");

        TextView nameTextView = findViewById(R.id.displayName);
        nameTextView.setText(name);

        TextView phoneTextView = findViewById(R.id.diaplayPhone);
        phoneTextView.setText(phone);


    }
}