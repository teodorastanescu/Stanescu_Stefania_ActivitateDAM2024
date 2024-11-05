package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaTerasa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_terasa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1=findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etDenumire= findViewById(R.id.editTextText);
                String denumire= etDenumire.getText().toString();

                EditText etCapacitate= findViewById(R.id.editTextText2);
                int capacitate= Integer.parseInt(etCapacitate.getText().toString());

                RatingBar etRating= findViewById(R.id.ratingBar);
                float rating= etRating.getRating();

                Spinner etSpinner= findViewById(R.id.spinner);
                String program= etSpinner.getSelectedItem().toString();

                Switch acord= findViewById(R.id.switch1);
                String deschis="";
                if(acord.isChecked()){
                    deschis=acord.getTextOn().toString();
                }
                else{
                    deschis=acord.getTextOff().toString();
                }
                CheckBox cbStatus=findViewById(R.id.checkBox);
                boolean status=((CheckBox)findViewById(R.id.checkBox)).isChecked();


                Terasă terasa=new Terasă(denumire, capacitate, rating, program, status);
                Intent it=new Intent();
                it.putExtra("", terasa);
            }


        });
    }
}