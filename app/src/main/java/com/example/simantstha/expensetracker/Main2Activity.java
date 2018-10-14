package com.example.simantstha.expensetracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import javax.security.auth.login.LoginException;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Main2Activity extends AppCompatActivity {
    ArrayList<String> expTit = new ArrayList<String>();
    ArrayList<Integer> expAmt = new ArrayList<Integer>();
    PieChartView pieChartView;
    List<SliceValue> pieData = new ArrayList<SliceValue>();
    int bg=0;
    public void popbox(View view)
    {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main2Activity.this);
        View mView = getLayoutInflater().inflate(R.layout.popup,null);
        final EditText title = (EditText) mView.findViewById(R.id.title);
        final EditText amount = (EditText) mView.findViewById(R.id.bgamount);
        Button expAdd = (Button) mView.findViewById(R.id.expAdd);
        expAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().isEmpty())
                {
                    Toast.makeText(Main2Activity.this, "Empty Feild", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Main2Activity.this, "Congratulations", Toast.LENGTH_SHORT).show();
                    expTit.add(title.getText().toString());
                    expAmt.add(Integer.parseInt(amount.getText().toString()));
                    pieData.add(new SliceValue(Integer.parseInt(amount.getText().toString()),Color.RED));
                    int sum=0;
                    for (Integer number : expAmt) {
                        sum+=number;
                    }
                    TextView t1=(TextView)findViewById(R.id.exp);
                    pie();
                    String b="Expense: "+Integer.toString(sum);
                    t1.setText(b);
                }
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void popbox2(View view)
    {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main2Activity.this);
        View mView = getLayoutInflater().inflate(R.layout.popup2,null);
        final EditText bgamount = (EditText) mView.findViewById(R.id.bgamount);
        Button budAdd = (Button) mView.findViewById(R.id.budAdd);
        budAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bgamount.getText().toString().isEmpty())
                {
                    Toast.makeText(Main2Activity.this, "Empty Feild", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Main2Activity.this, "Congratulations", Toast.LENGTH_SHORT).show();
                    TextView t=(TextView)findViewById(R.id.bug);
                    bg=Integer.parseInt(bgamount.getText().toString());
                    String a ="Budget: "+Integer.toString(bg);
                    t.setText(a);
                    pie();
                    pieData.add(new SliceValue(bg, Color.GREEN));
                }
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void actFunc(View view)
    {
        HashMap<String,Integer> m = new HashMap<String,Integer>();
        for(int i=0;i<expTit.size();i++)
        {
            m.put(expTit.get(i),expAmt.get(i));
        }
        Intent intent1 = new Intent(Main2Activity.this,Main3Activity.class);
        intent1.putExtra("hash", m);
        startActivity(intent1);
    }
    public void gphFunc(View view)
    {
        HashMap<String,Integer> m = new HashMap<String,Integer>();
        for(int i=0;i<expTit.size();i++)
        {
            m.put(expTit.get(i),expAmt.get(i));
        }
        Intent intent2 = new Intent(Main2Activity.this,Main4Activity.class);
        intent2.putExtra("hash1", m);
        startActivity(intent2);
    }
    public void pie()
    {
        pieChartView = findViewById(R.id.chart);
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(20);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expense Pie").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
