package com.example.husatelefon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Formular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnFormular= findViewById(R.id.btnFormular);
        btnFormular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText materialEt= findViewById(R.id.etMaterial);
                String material= materialEt.getText().toString();

                EditText lungimeEt= findViewById(R.id.etLungime);
                int lungime= Integer.parseInt(lungimeEt.getText().toString());

                Spinner modelSp= findViewById(R.id.spModel);
                String model= modelSp.getSelectedItem().toString();

                HusaTelefon ht=new HusaTelefon(material, lungime,model);
                Toast.makeText(Formular.this, ht.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(Formular.this, "hello", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent();
                intent.putExtra("ht", ht);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}