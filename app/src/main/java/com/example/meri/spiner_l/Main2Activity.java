package com.example.meri.spiner_l;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
String arr[]={"english","chinese","Nepali"};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.spinner,arr);
        adapter.setDropDownViewResource(R.layout.spinner);
        final Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                intent=new Intent();
                intent.putExtra("key",String.valueOf(position));
                setResult(1,intent);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button b=findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
