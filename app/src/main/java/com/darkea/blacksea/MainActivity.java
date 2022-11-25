package com.darkea.blacksea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variable
        playButton = findViewById(R.id.main_btn_play); //play button
        historyButton = findViewById(R.id.main_btn_history); //history button

        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(MainActivity.this, play.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });
        //end button play

        //start button history
        historyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, history.class);
                startActivity(i);
            }
        });
        //end button history

    }
}