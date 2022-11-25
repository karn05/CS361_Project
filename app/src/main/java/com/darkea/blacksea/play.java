package com.darkea.blacksea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class play extends AppCompatActivity {

    private Button Maintain, Socialize, Radar, Report, bacctoMenu;
    private DatabaseHandler DBHandler;
    private TextView topText, playText;
    private String dayText, storyGenerated;
    private String nameOfChar;
    private int currentDay;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.play);

            Context context = this;
            Maintain = findViewById(R.id.play_btn_maintain);
            Socialize = findViewById(R.id.play_btn_social);
            Radar = findViewById(R.id.play_btn_radar);
            Report = findViewById(R.id.play_btn_report);
            topText = (TextView) findViewById(R.id.play_top_text);
            playText = (TextView) findViewById(R.id.play_txt_pref);
            bacctoMenu = findViewById(R.id.play_btn_back);
            topText.setText(namePlay());
            DBHandler = new DatabaseHandler(play.this);

            try{
                if(! statusRecord().equals("error"))
                    status = statusRecord();
                else
                    status = "ok";

                //initialize day
                if(! dayRecord().equals("error")){
                    currentDay = Integer.parseInt(dayRecord());
                }
                else{
                    currentDay = 1;
                }

                //first day
                if(currentDay == 1){
                    SharedPreferences settings = context.getSharedPreferences("playHistory", Context.MODE_PRIVATE);
                    settings.edit().clear().commit();
                    String dayOneText = context.getString(R.string.example_txt_start);
                    savedHistory(dayOneText);
                    playText.setText(HistoricalRecord());
                    currentDay = 2;
                }else{
                    playText.setText(HistoricalRecord());
                }

            }catch (Exception e){
                Toast.makeText(play.this,"Section A : " + e.toString(),Toast.LENGTH_SHORT).show();
            }


            Maintain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(status.equals("ok")){
                        int max = 1;
                        int min = 0;
                        if(currentDay == 2){
                            Random rand = new Random();
                            int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                            String getName = "maintain_" + randomNumbruh;
                            int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                            String desucribtion = "initial";
                            if(describtion != 0){
                                desucribtion = context.getString(describtion);
                            }else{
                                desucribtion = "Null";
                            }

                            desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                            savedHistory(desucribtion);
                            playText.setText(HistoricalRecord());


                        }else if(currentDay == 3){
                            Random rand = new Random();
                            int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                            String getName = "maintain_" + randomNumbruh;
                            int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                            String desucribtion = "initial";
                            if(describtion != 0){
                                desucribtion = context.getString(describtion);
                            }else{
                                desucribtion = "Null";
                            }

                            desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                            savedHistory(desucribtion);
                            playText.setText(HistoricalRecord());
                        }else{
                            String dead = context.getString(R.string.dead);
                            savedHistory(dead);
                            status = "notOk";
                            saveStatus();
                            playText.setText(HistoricalRecord());
                        }

                        currentDay++;
                        saveDay();
                    }

                    else
                    {
                        Toast.makeText(play.this,"Your story has ended.",Toast.LENGTH_SHORT).show();
                    }
                    //======
                }
            });

            Socialize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(status.equals("ok")){
                        //random for socialize string
                        int min = 0;
                        int max = 1;
                        if(currentDay == 2){
                            Random rand = new Random();
                            int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                            String getName = "socialize_" + randomNumbruh;
                            int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                            String desucribtion = "initial";
                            if(describtion != 0){
                                desucribtion = context.getString(describtion);
                            }else{
                                desucribtion = "Null";
                            }

                            desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                            savedHistory(desucribtion);
                            playText.setText(HistoricalRecord());

                        }else if(currentDay == 4){
                            Random rand = new Random();
                            int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                            String getName = "socialize_" + randomNumbruh;
                            int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                            String desucribtion = "initial";
                            if(describtion != 0){
                                desucribtion = context.getString(describtion);
                            }else{
                                desucribtion = "Null";
                            }

                            desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                            savedHistory(desucribtion);
                            playText.setText(HistoricalRecord());

                        }else{
                            String dead = context.getString(R.string.dead);
                            savedHistory(dead);
                            status = "notOk";
                            saveStatus();
                            playText.setText(HistoricalRecord());
                        }

                        currentDay++;
                        saveDay();
                    }
                    else {
                        Toast.makeText(play.this,"Your story has ended.",Toast.LENGTH_SHORT).show();
                    }

                }
            });

            Radar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        if(status.equals("ok")){
                            int min = 0;
                            int max = 1;
                            if(currentDay == 2){
                                Random rand = new Random();
                                int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                                String getName = "radar_" + randomNumbruh;
                                int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                                String desucribtion = "initial";
                                if(describtion != 0){
                                    desucribtion = context.getString(describtion);
                                }else{
                                    desucribtion = "Null";
                                }

                                desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                                savedHistory(desucribtion);
                                playText.setText(HistoricalRecord());
                            }else if(currentDay == 5){
                                Random rand = new Random();
                                int randomNumbruh = rand.nextInt((max - min) + 1) + min;
                                String getName = "radar_" + randomNumbruh;
                                int describtion = getResources().getIdentifier(getName, "string", getPackageName());
                                String desucribtion = "initial";
                                if(describtion != 0){
                                    desucribtion = context.getString(describtion);
                                }else{
                                    desucribtion = "Null";
                                }

                                desucribtion = desucribtion.replace("**","0" + String.valueOf(currentDay));
                                savedHistory(desucribtion);
                                playText.setText(HistoricalRecord());
                                status = "notOk";
                                saveStatus();

                            }else {
                                String dead = context.getString(R.string.dead);
                                savedHistory(dead);
                                status = "notOk";
                                saveStatus();
                                playText.setText(HistoricalRecord());
                            }

                            currentDay++;
                            saveDay();
                            //random for radar
                        }
                        else {
                            Toast.makeText(play.this,"Your story has ended.",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(play.this,"Section RADAR : " + e.toString(),Toast.LENGTH_SHORT).show();
                    }

                    //=======
                }

            });

            Report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(status.equals("ok"))
                    {
                        Toast.makeText(play.this,"Your story has not ended yet.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        try{

                            if(currentDay < 5){
                                String Biogen = "Captain " + nameOfChar + " he survived for " + String.valueOf(currentDay) + " days.";
                                DBHandler.addNewData(nameOfChar, Biogen, currentDay);
                            }
                            else{
                                String Biogen = "Captain " + nameOfChar + " after " + String.valueOf(currentDay) + " he survived and retire back to his home.";
                                DBHandler.addNewData(nameOfChar, Biogen, currentDay);
                            }

                            //clear all
                            SharedPreferences clearPlayHis = context.getSharedPreferences("playHistory", Context.MODE_PRIVATE);
                            clearPlayHis.edit().clear().commit();

                            SharedPreferences clearStatus = context.getSharedPreferences("status", Context.MODE_PRIVATE);
                            clearStatus.edit().clear().commit();

                            SharedPreferences clearDay = context.getSharedPreferences("day", Context.MODE_PRIVATE);
                            clearDay.edit().clear().commit();

                            SharedPreferences clearName = context.getSharedPreferences("name", Context.MODE_PRIVATE);
                            clearName.edit().clear().commit();

                            currentDay = 1;
                            saveDay();
                            Intent i = new Intent(play.this, MainActivity.class);
                            startActivity(i);

                        }catch (Exception e){
                            Toast.makeText(play.this,"Error : " + e.toString(),Toast.LENGTH_LONG).show();

                        }


                    }
                }
            });




            bacctoMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(play.this, MainActivity.class);
                    startActivity(i);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(play.this,"Section All : " + e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    //================================================

    private String namePlay(){
        try{
            String nameResult = nameRecord();
            if(! nameRecord().equals("error"))
            {
                return nameResult;
            }
            else
            {
                nameOfChar = randomName();
                saveName();
                return nameOfChar;
            }

        }catch (Exception e){
            return e.toString();
        }

    }

    private String randomName(){
        Random rand = new Random();

        String[] strName = new String[] {"Khodyayev", "Aksyonov", "Gushchin", "Babikov", "Siyankovsky", "Bukavitsky", "Somsky"};
        String[] surName = new String[] {"Valeryevich", "Larionovich", "Victorovich",
                "Yanovich", "Valentinovich", "Andreevich", "Tarasovich", "Mobiks", "Ruslanovich",
                "Jeamterasky", "Musky"};

        return strName[rand.nextInt(strName.length)] + " " +surName[rand.nextInt(surName.length)];
    }


    private String HistoricalRecord() {
        SharedPreferences sp = getSharedPreferences("playHistory", Context.MODE_PRIVATE);
        return  sp.getString("playHistory", "error");
    }

    private String nameRecord() {
        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        return  sp.getString("name", "error");
    }

    private String dayRecord(){
        SharedPreferences sp = getSharedPreferences("day", Context.MODE_PRIVATE);
        return  sp.getString("day", "error");
    }

    private String statusRecord(){
        SharedPreferences sp = getSharedPreferences("status", Context.MODE_PRIVATE);
        return  sp.getString("status", "error");
    }

    private void saveDay(){
        SharedPreferences spr = getSharedPreferences("day", Context.MODE_PRIVATE);
        SharedPreferences.Editor sprEdit = spr.edit();
        sprEdit.putString("day", String.valueOf(currentDay));
        sprEdit.commit();
    }

    private void saveStatus(){
        SharedPreferences spr = getSharedPreferences("status", Context.MODE_PRIVATE);
        SharedPreferences.Editor sprEdit = spr.edit();
        sprEdit.putString("status", String.valueOf(currentDay));
        sprEdit.commit();
    }

    private void saveName(){
        SharedPreferences spr = getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor sprEdit = spr.edit();
        sprEdit.putString("name", nameOfChar);
        sprEdit.commit();
    }


    public void savedHistory(String PlayerPlayedHistory){
        SharedPreferences spr = getSharedPreferences("playHistory", Context.MODE_PRIVATE);
        SharedPreferences.Editor sprEdit = spr.edit();
        String historicalRecorder = HistoricalRecord();
        String storyResult = PlayerPlayedHistory;
        if(! historicalRecorder.equals("error")) {
            storyResult = historicalRecorder + "\n" + storyResult;
        }
        sprEdit.putString("playHistory", storyResult);
        sprEdit.commit();
    }
}
