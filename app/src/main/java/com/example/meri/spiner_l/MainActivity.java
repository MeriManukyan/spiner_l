package com.example.meri.spiner_l;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Intent intent;
TextView tv;
String s="hello world";
SharedPreferences sp;
SharedPreferences.Editor et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        load();
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!data.equals(null)) {
            int i = Integer.valueOf(data.getStringExtra("key").toString());
            s=getResources().getStringArray(R.array.n)[i];
            tv.setText(getResources().getStringArray(R.array.n)[i]);
        }
        save();

    }
    void save()
    {
        sp=getPreferences(MODE_PRIVATE);
        et=sp.edit();
        et.putString("0",s);
        et.commit();
    }
    void load(){
        sp=getPreferences(MODE_PRIVATE);
        String s=sp.getString("0","hello world");
        tv.setText(s);
    }
}
