package org.app.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btn1, btnmain, btnview;
    TextView textmainid, textmainpw, text3, text4, text5, text6, text7;

    int version = 1;
    log2.DatabaseOpenHelper helper;
    static SQLiteDatabase database;

    String sql;
    Cursor cursor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("딸기를 찾아라!");

        btn1= (Button) findViewById(R.id.button);
        btnmain= (Button) findViewById(R.id.buttonMain);
        btnview= (Button) findViewById(R.id.button3);
        textmainid =(TextView) findViewById(R.id.textView4);
        textmainpw =(TextView) findViewById(R.id.textView5);
        text3 =(TextView) findViewById(R.id.textView6);
        text4 =(TextView) findViewById(R.id.textView7);
        text5 =(TextView) findViewById(R.id.textView8);
        text6 =(TextView) findViewById(R.id.textView9);
        text7 =(TextView) findViewById(R.id.textView10);
/*
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPW = intent.getStringExtra("userPW");
        Integer g1s = intent.getIntExtra("g1s",0);
        Integer g2s = intent.getIntExtra("g2s",0);
        Integer g3s = intent.getIntExtra("g3s",0);
        Integer g4s = intent.getIntExtra("g4s",0);
        Integer ts = intent.getIntExtra("ts",0);

        Intent intent3 = new Intent(getApplicationContext(), story.class);
        intent3.putExtra("userID",userID);///////////

        textmainid.setText(userID);
        textmainpw.setText(userPW);
        text3.setText(String.valueOf(g1s));
        text4.setText(String.valueOf(g2s));
        text5.setText(String.valueOf(g3s));
        text6.setText(String.valueOf(g4s));
        text7.setText(String.valueOf(ts));
*/

        textmainid.setText(log2.getid()+"  ");
        textmainpw.setText(log2.getpw()+"  ");
        text3.setText(log2.getg1()+"  ");
        text4.setText(log2.getg2()+"  ");
        text5.setText(log2.getg3()+"  ");
        text6.setText(log2.getg4()+"  ");
        text7.setText(log2.gettotal()+"  ");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, sub.class);///////
                startActivity(intent);//////////////////////////////////

            }
        });

        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, log.class);///////
                startActivity(intent);//////////////////////////////////

            }
        });//helper.updateUsers(database,3,0,0,0,0);

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.updateUsers(3,0,0,0,0);
                //helper.updatepw();
                text3.setText(log2.getg1()+"  ");
            }
        });
    }
}
