package org.app.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class story extends AppCompatActivity {

    Button btn1;
    TextView text1, text2, text3, text4, text5, text6, text7;
    TextView text11, text12, text13, text14, text15, text16, text17;

    int version = 1;
    log2.DatabaseOpenHelper helper;
    static SQLiteDatabase database;

    String sql;
    Cursor cursor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        setTitle("딸기를 찾아라!");

        btn1= (Button) findViewById(R.id.button);
        text1 =(TextView) findViewById(R.id.textView4);
        text2 =(TextView) findViewById(R.id.textView5);
        text3 =(TextView) findViewById(R.id.textView6);
        text4 =(TextView) findViewById(R.id.textView7);
        text5 =(TextView) findViewById(R.id.textView8);
        text6 =(TextView) findViewById(R.id.textView9);
        text7 =(TextView) findViewById(R.id.textView10);

        text11 =(TextView) findViewById(R.id.textView11);
        text12 =(TextView) findViewById(R.id.textView12);
        text13 =(TextView) findViewById(R.id.textView13);
        text14 =(TextView) findViewById(R.id.textView14);
        text15 =(TextView) findViewById(R.id.textView15);
        text16 =(TextView) findViewById(R.id.textView16);
        text17 =(TextView) findViewById(R.id.textView17);
/*
        text1.setText(userID);
        text2.setText(userPW);
        text3.setText(String.valueOf(g1s));
        text4.setText(String.valueOf(g2s));
        text5.setText(String.valueOf(g3s));
        text6.setText(String.valueOf(g4s));
        text7.setText(String.valueOf(ts));
*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(story.this, sub.class);///////
                //startActivity(intent);//////////////////////////////////


            }
        });


    }
}