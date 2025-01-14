package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AdaugaTerasa extends AppCompatActivity {

    private TerasaDataBase database=null;
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

        database= Room.databaseBuilder(this, TerasaDataBase.class, "TerasaDB").build();

        Intent intent = getIntent();
        if (intent.hasExtra("terasa"))
        {
            Terasă terasa = intent.getParcelableExtra("terasa");
            EditText etDenumire= findViewById(R.id.editTextText);
            EditText etCapacitate= findViewById(R.id.editTextText2);
            RatingBar etRating= findViewById(R.id.ratingBar);
            Spinner etSpinner= findViewById(R.id.spinner);
            CheckBox cbStatus=findViewById(R.id.checkBox);

            etDenumire.setText(terasa.getDenumire());
            etCapacitate.setText(String.valueOf(terasa.getCapacitate()));
            etRating.setRating(terasa.getRating());
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) etSpinner.getAdapter();
            int position = adapter.getPosition(terasa.getProgram());
            if (position >= 0) {
                etSpinner.setSelection(position);
            }
            cbStatus.setChecked(terasa.getStatus());


        }


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

                Executor executor= Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        database.terasaDAO().insertTerasa(terasa);
                    }
                });

                Intent it=new Intent();
                it.putExtra("terasa", terasa);
                Toast.makeText(AdaugaTerasa.this, terasa.toString(), Toast.LENGTH_LONG).show();
                setResult(RESULT_OK,it);
                finish();
            }


        });
    }
}