package com.example.simantstha.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;


public class Main4Activity extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        HashMap<String, Integer> hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("hash1");
        ArrayList<Integer> expAmt=new ArrayList<Integer>();
        StringBuilder strb;
        StringBuilder strBuilder;
        strBuilder = new StringBuilder();
        strb =new StringBuilder();
        int j=0;
        for(String tit : hashMap.keySet()) {
            strBuilder.append(Integer.toString(j++)+"-"+tit+"\n");
        }
        expAmt.addAll(hashMap.values());
        TextView t = findViewById(R.id.textView4);
        GraphView graph = findViewById(R.id.graph);
        series = new LineGraphSeries<>();
        for(int i = 0; i<expAmt.size(); i++)
           series.appendData(new DataPoint(i, expAmt.get(i)), true, expAmt.size());
        graph.addSeries(series);
        t.setText(strBuilder.toString());
    }
}
