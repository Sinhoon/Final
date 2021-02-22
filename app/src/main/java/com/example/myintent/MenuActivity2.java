package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processIntent(getApplicationContext(),passedIntent);

    }


    private void processIntent(Context context, Intent intent){
        if(intent != null);{
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            if (names != null){
                System.out.println(names);
                Toast.makeText(getApplicationContext(),String.valueOf(names.size()),Toast.LENGTH_LONG).show();
            }

            SimpleData data = (SimpleData)intent.getParcelableExtra("data");
            if (data !=null){
                Toast.makeText(getApplicationContext(),data.message,Toast.LENGTH_LONG).show();
            }

        }
    }

}