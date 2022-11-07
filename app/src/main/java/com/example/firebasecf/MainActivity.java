package com.example.firebasecf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference dbReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia de la base de datos
        database = FirebaseDatabase.getInstance();
        //Referencia a un child de la base de datos
        dbReference = database.getReference("Alumno");
        ValueEventListener alumnoListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("Hubo un cambio");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");
            }
        };
        dbReference.addValueEventListener(alumnoListener);




    }
}