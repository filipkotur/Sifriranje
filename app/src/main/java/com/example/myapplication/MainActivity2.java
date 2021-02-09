package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.ui.main.SectionsPagerAdapter;
import android.content.Intent;
import android.net.Uri;
import java.util.Random;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FloatingActionButton fab = findViewById(R.id.fab);


        // Bind the components to their respective objects
        // by assigning their IDs
        // with the help of findViewById() method

        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                final Paint p = new Paint();

                // Creating explicit intent


                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
}