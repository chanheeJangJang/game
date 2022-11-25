package org.app.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {


    TextView text1, text2, text3, text4, text5, text6;
    EditText etext1, etext2, etext3, etext4, etextid, etextpw;
    Button btn1;

    String sql;
    Cursor cursor;
    int version = 1;
    log2.DatabaseOpenHelper helper; ////////   여기부분 참고코드랑 좀 다름
    SQLiteDatabase database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        text1 = (TextView) findViewById(R.id.signup1);
        text2 = (TextView) findViewById(R.id.signup2);
        text3 = (TextView) findViewById(R.id.signup3);
        text4 = (TextView) findViewById(R.id.signup4);
        text5 = (TextView) findViewById(R.id.signup5);
        text6 = (TextView) findViewById(R.id.signup6);

        etext1 = (EditText)  findViewById(R.id.editTextText1);
        etext2 = (EditText)  findViewById(R.id.editTextText2);
        etext3 = (EditText)  findViewById(R.id.editTextText3);
        etext4 = (EditText)  findViewById(R.id.editTextText4);
        etextid = (EditText)  findViewById(R.id.editTextText5);
        etextpw = (EditText)  findViewById(R.id.editTextText6);

        btn1 = (Button) findViewById(R.id.signupbtn);

        helper = new log2.DatabaseOpenHelper(signup.this, log2.DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = etextid.getText().toString();
                String pw = etextpw.getText().toString();
                Integer g1 = 0, g2 = 0, g3 = 0, g4 = 0, total = 0;////****************

                if(id.length() == 0 || pw.length() == 0) {
                    //아이디와 비밀번호는 필수 입력사항입니다.
                    Toast toast = Toast.makeText(signup.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 0){
                    //존재하는 아이디입니다.
                    Toast toast = Toast.makeText(signup.this, "존재하는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    helper.insertUser(database,id,pw,0,0,0,0,0);
                    //helper.updateUsers(database,3,0,0,0,0);
                    Toast toast = Toast.makeText(signup.this, "가입이 완료되었습니다. 로그인을 해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(getApplicationContext(),log2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }



}