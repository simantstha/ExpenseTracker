package com.example.simantstha.expensetracker;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView t=(TextView) findViewById(R.id.actview1);
        Intent intent = getIntent();
        HashMap<String, Integer> hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("hash");
        StringBuilder strBuilder;
        StringBuilder strb;
        strBuilder = new StringBuilder();
        strb =new StringBuilder();
        for(String tit : hashMap.keySet()) {
            strBuilder.append("     "+tit+"                        "+hashMap.get(tit)+"\n");
        }
        t.setText(strBuilder.toString());
    }
}
