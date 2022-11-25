package com.darkea.blacksea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class history extends AppCompatActivity  {

    private Button back2Menu;
    private ArrayList<Instance> instanceArrayList;
    private DatabaseHandler DBHandler;
    private Adapter adapter;
    private RecyclerView recyclerviews;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        try{
            instanceArrayList = new ArrayList<>();
            DBHandler = new DatabaseHandler(history.this);
            instanceArrayList = DBHandler.readCourses();
            adapter = new Adapter(instanceArrayList, history.this);
            recyclerviews = findViewById(R.id.histolist);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(history.this, RecyclerView.VERTICAL, false);
            recyclerviews.setLayoutManager(linearLayoutManager);
            recyclerviews.setAdapter(adapter);

        }catch (Exception e){
            Toast.makeText(history.this,e.toString(),Toast.LENGTH_SHORT).show();
        }

        //initialize
        back2Menu = findViewById(R.id.histoty_btn_back);

        back2Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(history.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}
