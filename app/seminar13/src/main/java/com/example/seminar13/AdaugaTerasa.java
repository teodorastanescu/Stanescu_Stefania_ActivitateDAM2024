package com.example.seminar13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdaugaTerasa extends AppCompatActivity {

    private DatabaseReference databaseReference;

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


        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etCapacitate = findViewById(R.id.editTextText);
                int capacitate= Integer.parseInt(etCapacitate.getText().toString());

                EditText etRating = findViewById(R.id.editTextText2);
                int rating = Integer.parseInt(etRating.getText().toString());

                Terasa terasa = new Terasa(capacitate, rating);

                CheckBox cb= findViewById(R.id.checkBox);
                if(cb.isChecked()){
                    databaseReference= FirebaseDatabase.getInstance().getReference("test");
                    databaseReference.push().setValue(terasa);
                }
                finish();
            }
        });

    }
}