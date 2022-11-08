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
                System.out.println("SNAPSHOT--------");
                System.out.println(snapshot);
                System.out.println(snapshot.getValue());
                System.out.println(snapshot.child("2").getValue());
                for (DataSnapshot alumno:snapshot.getChildren()){
                    String nombre = alumno.child("nombre").getValue().toString();
                    String apellido = alumno.child("apellido").getValue().toString();
                    double nota1 = Double.parseDouble(alumno.child("notas").child("nota1").getValue().toString());
                    double nota2 = Double.parseDouble(alumno.child("notas").child("nota2").getValue().toString());
                    double promedio = (nota1+nota2)/2;
                    System.out.println(nombre+" ");
                    System.out.println(apellido+" ");
                    System.out.println(nota1+" ");
                    System.out.println(nota2+" ");
                    System.out.println(promedio+" ");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");
            }
        };
        dbReference.addValueEventListener(alumnoListener);




    }
}