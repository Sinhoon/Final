package com.example.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menubutton = (Button) findViewById(R.id.button);
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);

            }
        });

        Button callbutton = (Button) findViewById(R.id.button3);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiver = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + receiver));
                startActivity(intent);

                /*Intent intent2 = new Intent();
                ComponentName name = new ComponentName("com.example.myintent" ,"com.example.myintent.CallActivity");
                intent2.setComponent(name);
                startActivity(intent2);*/
            }
        });


        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity2.class);
                ArrayList<String> names = new ArrayList<>();
                names.add("a");
                names.add("b");
                intent.putExtra("names", names);

                SimpleData data = new SimpleData(100, "Hello");
                intent.putExtra("data", data);
                startActivityForResult(intent, 101);
            }
        });


        Button button5 = (Button) findViewById(R.id.button6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("name",editText.getText().toString());
                startService(intent);

            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode);
        if (requestCode == 101) {
            System.out.println("check");
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "응답값:" + name, LENGTH_LONG).show();
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("name", "test");
        edit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null ){
            String name = pref.getString("name","");
            Toast.makeText(this,name, LENGTH_LONG).show();
        }
    }
}