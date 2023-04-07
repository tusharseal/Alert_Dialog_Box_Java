package com.example.alertdialogboxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Terms & Conditions");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setMessage("Have you Read All the Terms and Conditions");
                alertDialog.setButton("Yes, I've Read", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this, "Yes,You can proceed Now..", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        btn2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
                delDialog.setTitle("Delete?");
                delDialog.setIcon(R.drawable.delete);
                delDialog.setMessage("Do You Really want to delete?");
                delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

                delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                delDialog.show();
            }
        });

        btn3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Third Dialog On Back Pressed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Exit?");
        exitDialog.setIcon(R.drawable.exit);
        exitDialog.setMessage("Do You Really want to Exit?");
        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Tata! Bye-Bye!", Toast.LENGTH_SHORT).show();
            MainActivity.super.onBackPressed();
            }
        });

        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation Cancelled!!", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();
    }
}