package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static  final String DEFAULT="N/A";

    TextView tv1,tv2,tv3,tv4;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
                String name=sharedPreferences.getString("name",DEFAULT);
                String password=sharedPreferences.getString("pass",DEFAULT);
                if(name.equals(DEFAULT) || password.equals(DEFAULT))
                {
                    Toast.makeText(SecondActivity.this, "No data was found", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SecondActivity.this, "Data loaded Successfully", Toast.LENGTH_SHORT).show();
                    tv2.setText(name);
                    tv4.setText(password);
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}