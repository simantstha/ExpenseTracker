package com.example.simantstha.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void login(View view)
    {
        EditText uname = (EditText) findViewById(R.id.uname);
        String name = uname.getText().toString();
        String[] arr={"simant","abc"};
        EditText pass = (EditText) findViewById(R.id.pwd);
        String pwd = pass.getText().toString();
        if(name == name && pwd == pwd)
        {
            Toast.makeText(MainActivity.this, "Congratulations!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
