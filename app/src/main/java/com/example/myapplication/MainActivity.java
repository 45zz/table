package com.example.myapplication;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    int options=0;
    int color=0;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    Dialog dialog;
    CharSequence group;

    private Button button15;
    private Button button16;
    private Button button19;
    private Button button20;
    private Button button23;
    private Button button24;
    private Button button27;
    private Button button28;
    private Button button31;
    private Button button32;
    private Button button35;
    private Button button36;

    int lblue = Color.parseColor("#1E90FF");
    int dgrey = Color.parseColor("#282828");
    int lgrey = Color.parseColor("#505050");
    int green = Color.parseColor("#00a029");
    int black = Color.parseColor("#0A0A0A");

    int grey = Color.parseColor("#4F6F6F");
    int lred = Color.parseColor("#FFB6C1");
    int lgreen = Color.parseColor("#008000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        mDb = mDBHelper.getWritableDatabase();
        //день недели
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);

        String time = dayOfTheWeek;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_view);
        EditText Etext = dialog.findViewById(R.id.dialogText);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        Button OK = dialog.findViewById(R.id.OK);

        Button button2 = findViewById(R.id.button2);
        Button Options = findViewById(R.id.Options);
        Button button37 = findViewById(R.id.button37);
        Button Color = findViewById(R.id.Color);
        Button Reset = findViewById(R.id.Reset);
        Button Gruppa = findViewById(R.id.gruppa);

        LinearLayout Layout = findViewById(R.id.Layout);
        Button button3 = findViewById(R.id.button3);

        Button button13 = findViewById(R.id.button13);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        Button button25 = findViewById(R.id.button25);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        Button button29 = findViewById(R.id.button29);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        Button button33 = findViewById(R.id.button33);
        button35 = findViewById(R.id.button35);
        button36 = findViewById(R.id.button36);

        Button button14 = findViewById(R.id.button14);
        Button button18 = findViewById(R.id.button18);
        Button button22 = findViewById(R.id.button22);
        Button button26 = findViewById(R.id.button26);
        Button button30 = findViewById(R.id.button30);
        Button button34 = findViewById(R.id.button34);

        button37.setText((CharSequence) time);

        View.OnClickListener OKEY =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group=Etext.getText().toString();
                dialog.dismiss();
            }
        };

        View.OnClickListener Opcii = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (options==0){
                    Color.setVisibility(View.VISIBLE);
                    Reset.setVisibility(View.VISIBLE);
                    Gruppa.setVisibility(View.VISIBLE);
                    options=1;
                }else{
                    Color.setVisibility(View.INVISIBLE);
                    Reset.setVisibility(View.INVISIBLE);
                    Gruppa.setVisibility(View.INVISIBLE);
                    options=0;
                }
            }
        };

        View.OnClickListener Grup = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        };

        View.OnClickListener Cvet = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color==0) {
                    button2.setBackgroundColor(grey);
                    Options.setBackgroundColor(grey);
                    button37.setBackgroundColor(grey);
                    Color.setBackgroundColor(grey);
                    Reset.setBackgroundColor(grey);

                    Layout.setBackgroundColor(lred);
                    button3.setBackgroundColor(lred);

                    button13.setBackgroundColor(lgreen);
                    button15.setBackgroundColor(lgreen);
                    button16.setBackgroundColor(lgreen);
                    button17.setBackgroundColor(lgreen);
                    button19.setBackgroundColor(lgreen);
                    button20.setBackgroundColor(lgreen);
                    button21.setBackgroundColor(lgreen);
                    button23.setBackgroundColor(lgreen);
                    button24.setBackgroundColor(lgreen);
                    button25.setBackgroundColor(lgreen);
                    button27.setBackgroundColor(lgreen);
                    button28.setBackgroundColor(lgreen);
                    button28.setBackgroundColor(lgreen);
                    button29.setBackgroundColor(lgreen);
                    button31.setBackgroundColor(lgreen);
                    button32.setBackgroundColor(lgreen);
                    button33.setBackgroundColor(lgreen);
                    button35.setBackgroundColor(lgreen);
                    button36.setBackgroundColor(lgreen);

                    button14.setBackgroundColor(black);
                    button18.setBackgroundColor(black);
                    button22.setBackgroundColor(black);
                    button26.setBackgroundColor(black);
                    button30.setBackgroundColor(black);
                    button34.setBackgroundColor(black);
                    button14.setTextColor(lblue);
                    button18.setTextColor(lblue);
                    button22.setTextColor(lblue);
                    button26.setTextColor(lblue);
                    button30.setTextColor(lblue);
                    button34.setTextColor(lblue);
                    color=1;
                }else{
                    button2.setBackgroundColor(lblue);
                    Options.setBackgroundColor(lblue);
                    button37.setBackgroundColor(lblue);
                    Color.setBackgroundColor(lblue);
                    Reset.setBackgroundColor(lblue);

                    Layout.setBackgroundColor(black);
                    button3.setBackgroundColor(black);

                    button13.setBackgroundColor(dgrey);
                    button15.setBackgroundColor(dgrey);
                    button16.setBackgroundColor(dgrey);
                    button17.setBackgroundColor(dgrey);
                    button19.setBackgroundColor(dgrey);
                    button20.setBackgroundColor(dgrey);
                    button21.setBackgroundColor(dgrey);
                    button23.setBackgroundColor(dgrey);
                    button24.setBackgroundColor(dgrey);
                    button25.setBackgroundColor(dgrey);
                    button27.setBackgroundColor(dgrey);
                    button28.setBackgroundColor(dgrey);
                    button28.setBackgroundColor(dgrey);
                    button29.setBackgroundColor(dgrey);
                    button31.setBackgroundColor(dgrey);
                    button32.setBackgroundColor(dgrey);
                    button33.setBackgroundColor(dgrey);
                    button35.setBackgroundColor(dgrey);
                    button36.setBackgroundColor(dgrey);

                    button14.setBackgroundColor(lgrey);
                    button18.setBackgroundColor(lgrey);
                    button22.setBackgroundColor(lgrey);
                    button26.setBackgroundColor(lgrey);
                    button30.setBackgroundColor(lgrey);
                    button34.setBackgroundColor(lgrey);
                    button14.setTextColor(green);
                    button18.setTextColor(green);
                    button22.setTextColor(green);
                    button26.setTextColor(green);
                    button30.setTextColor(green);
                    button34.setTextColor(green);
                    color=0;
                }
            }
        };

        View.OnClickListener Update = new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Cursor cursor = mDb.rawQuery("SELECT * FROM rasp", null);

                cursor.moveToFirst();
                cursor.moveToNext();
                String groupT="";
                int k=0;
                for (int i=0;i<336;i++){
                    groupT="";
                    groupT=cursor.getString(i);
                    if (group.equals(groupT)){
                        k=i;
                        break;
                    }
                }

                //день недели
                int day=0;
                if (dayOfTheWeek.equals("понедельник")){
                    day=3;
                }
                if (dayOfTheWeek.equals("вторник")){
                    day=15;
                }
                if (dayOfTheWeek.equals("среда")){
                    day=27;
                }
                if (dayOfTheWeek.equals("четверг")){
                    day=39;
                }
                if (dayOfTheWeek.equals("пятница")){
                    day=51;
                }
                if (dayOfTheWeek.equals("суббота")) {
                    day=63;
                }
                GregorianCalendar calendar = new GregorianCalendar(2021,
                        Calendar.DECEMBER, 31);
                int week = calendar.get(Calendar.WEEK_OF_YEAR);
                week-=38;
                int chet=0;
                if (week%2==0)
                    chet=1;

                //1 пара предмет
                String product = "";
                cursor.moveToFirst();
                for (int i = 0; i<day+chet; i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button15.setText(product);
                //1 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button16.setText(product);

                //2 пара предмет
                product = "";
                for (int i=0;i<2;i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button19.setText(product);
                //2 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button20.setText(product);

                //3 пара предмет
                product = "";
                for (int i=0;i<2;i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button23.setText(product);
                //3 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button24.setText(product);

                //4 пара предмет
                product = "";
                for (int i=0;i<2;i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button27.setText(product);
                //4 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button28.setText(product);

                //5 пара предмет
                product = "";
                for (int i=0;i<2;i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button31.setText(product);
                //5 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button32.setText(product);

                //6 пара предмет
                product = "";
                for (int i=0;i<2;i++)
                    cursor.moveToNext();
                product+=cursor.getString(k);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button35.setText(product);
                //6 пара препод
                product = "";
                product+=cursor.getString(k+1);
                if (product.equals("null")){
                    product="Пары нет";
                }
                button36.setText(product);
                cursor.close();
            }
        };
        Gruppa.setOnClickListener(Grup);
        Reset.setOnClickListener(Update);
        Options.setOnClickListener(Opcii);
        Color.setOnClickListener(Cvet);
        OK.setOnClickListener(OKEY);
    }
}