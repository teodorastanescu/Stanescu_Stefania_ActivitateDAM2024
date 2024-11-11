package com.example.husatelefon;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.husatelefon.Formular;
import com.example.husatelefon.HusaTelefon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<HusaTelefon> listaHusaTelefonM= null;
    ArrayAdapter<HusaTelefon> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listaHusaTelefonM=new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(), Formular.class);
                startActivityForResult(it,200);

            }
        });

        ListView lv= findViewById(R.id.lv);
        adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaHusaTelefonM);
        lv.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            if(resultCode==RESULT_OK){
                HusaTelefon husaTelefon= data.getParcelableExtra("ht");
                Toast.makeText(this, husaTelefon.toString(), Toast.LENGTH_SHORT).show();
                listaHusaTelefonM.add(husaTelefon);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opt1){
            Intent it=new Intent(getApplicationContext(), Formular.class);
            startActivityForResult(it,200);

        }
        else
            Toast.makeText(this, "ceva", Toast.LENGTH_SHORT).show();

        return true;
    }
}