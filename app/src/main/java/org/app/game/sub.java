package org.app.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class sub extends AppCompatActivity {

    int seconds =30;
    int count=0;
    int score =0;

    String sql;
    Cursor cursor;
    int version = 1;
    log2.DatabaseOpenHelper helper; ////////   여기부분 참고코드랑 좀 다름
    SQLiteDatabase database;

    TextView text1, text2, text3, textSec, textid;
    Button btn1, btn2;
    ImageView imgstaw, imgback, imgw;
    ImageButton imgbtn1, imgbtn2, imgbtn3, imgbtn4, imgbtn5, imgbtn6, imgbtn7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        setTitle("딸기를 찾아라!");
        textid = (TextView) findViewById(R.id.textView);////////////
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        textSec = (TextView) findViewById(R.id.textTime);
        btn1 = (Button) findViewById(R.id.btnstart);
        btn2 = (Button) findViewById(R.id.button2);
        imgstaw = (ImageView) findViewById(R.id.imageView1);
        imgback = (ImageView) findViewById(R.id.imageViewback);
        imgw = (ImageView) findViewById(R.id.imageView_W);
        imgbtn1 = (ImageButton) findViewById(R.id.imageButton1);
        imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imgbtn3 = (ImageButton) findViewById(R.id.imageButton3);
        imgbtn4 = (ImageButton) findViewById(R.id.imageButton4);
        imgbtn5 = (ImageButton) findViewById(R.id.imageButton5);
        imgbtn6 = (ImageButton) findViewById(R.id.imageButton6);
        imgbtn7 = (ImageButton) findViewById(R.id.imageButton7);
/*
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        textid.setText(userID);
*/

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                imgback.setVisibility(View.VISIBLE);
                imgbtn1.setVisibility(View.VISIBLE);
                imgbtn2.setVisibility(View.VISIBLE);
                imgbtn3.setVisibility(View.VISIBLE);
                imgbtn4.setVisibility(View.VISIBLE);
                imgbtn5.setVisibility(View.VISIBLE);
                imgbtn6.setVisibility(View.VISIBLE);
                imgbtn7.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);

                //btn2.setBackgroundColor(Color.rgb(0x20,0x20,0x20)); //검정

                Timer timer = new Timer();
                TimerTask jang = new TimerTask() {
                    public void run() {
                        seconds -= 1;
                        textSec.setText("남은 시간 : " + seconds);
                        if(seconds == 0) {
                            btn2.setBackgroundColor(Color.rgb(0x20,0x20,0x20));
                            imgw.setVisibility(View.INVISIBLE);

                            timer.cancel();
                            if(count>=4 && count<7) {
                                textSec.setText("Good");
                                score =2;
                                timer.cancel();
                                database.execSQL("UPDATE BAKINGGAME SET g1 = 2 WHERE id = '" + textid.getText().toString() + "'" );
                                database.close();

                            }
                            else if(count<4){
                                textSec.setText("Bad");
                                score =1;
                                timer.cancel();

                            }
                            /*
                            try {
                                btn2.setVisibility(View.VISIBLE);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                             */
                        }
                        else if(count == 7){
                            btn2.setBackgroundColor(Color.rgb(0x20,0x20,0x20));
                            imgw.setVisibility(View.INVISIBLE);

                            textSec.setText("Perfect");
                            score=3;


                            timer.cancel();
                            /*
                            try {
                                btn2.setVisibility(View.VISIBLE);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                             */
                        }

                    }
                };
                timer.schedule(jang, 1000, 1000);


            }
        });

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn1.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn2.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn3.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn4.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn5.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn6.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        imgbtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgbtn7.setVisibility(View.INVISIBLE);
                count= count + 1;
                text2.setText(String.valueOf(count));

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(sub.this, story.class);///////

                if(count == 7) {
                    startActivity(intent);//////////////////////////////////
                }

            }
        });










    }
}