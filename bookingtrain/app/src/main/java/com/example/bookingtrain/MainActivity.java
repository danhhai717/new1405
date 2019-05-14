package com.example.bookingtrain;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import android.text.InputType;
import android.view.View;
import static android.R.id.input;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtNoidung ,edtphone, et;
    Button btnClick1, btnClick2;
    CheckBox ckvip;
    TextView txttype,txtcur;
    RadioButton rdoseat,rdobeth;
    Spinner splist;
    RadioGroup rdgroup;
    int money;
    int result;
    String city, language;
    String moneyLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reflection();


        final ArrayList<String> arraycur = new ArrayList<String>();
        arraycur.add("USD");
        arraycur.add("VND");
        arraycur.add("BATH");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arraycur);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        splist.setAdapter(arrayAdapter);

        splist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                }


            public void onNothingSelect(AdapterView<?> parent) {

            }
        });


        btnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung = edtNoidung.getText().toString();
                String a = "";
                if (et.getText().toString().trim().length() > 0 && !et.getText().toString().trim().equals("."))
                    ;
                String textValue = et.getText().toString();


                    if (ckvip.isChecked()) {
                        a += ckvip.getText();
                        result = money -(money/100*20);
                        if(splist.getSelectedItem().toString() == "USD") {
                            city ="US";
                            language ="en";
                            moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/23300);

                        } else if(splist.getSelectedItem().toString() =="VND"){
                            city ="ThaiLand";
                            language ="Thai";
                            moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/732.39);
                        }else if(splist.getSelectedItem().toString() =="BATH"){
                        city ="VN";
                        language ="vi";
                        moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/money);
                    }} else if(splist.getSelectedItem().toString() =="BATH"){
                        city ="VN";
                        language ="vi";
                        moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/money);
                    } else if (splist.getSelectedItem().toString() =="USD"){
                    city ="VN";
                    language ="vi";
                    moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/money/732.39);
                }else if(splist.getSelectedItem().toString() =="VND"){
                    city ="VN";
                    language ="vi";
                    moneyLocal = NumberFormat.getCurrencyInstance(new Locale(language,city)).format(result/money/23300);
                }


                    if (rdoseat.isChecked()) {
                        money= 500000;


                        Toast.makeText(MainActivity.this, "Welcome" + " " + noidung + "\n" + "Type member:"
                                + " " + a + "\n"+ "Price: " + moneyLocal+ "(discount 20%)"+ "\n" + "Type seat:" + " " + rdoseat.getText() +"\n", Toast.LENGTH_LONG).show();
                    }
                    if (rdobeth.isChecked()) {
                         money =100000;

                        Toast.makeText(MainActivity.this, "Welcome" + " " + noidung + "\n" + "Type member:"
                                + " " + a + "\n" + "Price: " + moneyLocal+ "(discount 20%)" + "\n" +" Type seat :" + " " + rdobeth.getText(), Toast.LENGTH_LONG).show();
                    }


                }

        });


        btnClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }



    private void reflection() {


        splist = (Spinner) findViewById(R.id.spinner);

        edtNoidung = (EditText) findViewById(R.id.editText1);
        edtphone = (EditText) findViewById(R.id.editText2);
        btnClick1 = (Button) findViewById(R.id.button9);
        btnClick2 = (Button) findViewById(R.id.button10);
        ckvip = (CheckBox) findViewById(R.id.checkBox);
        txtcur = (TextView) findViewById(R.id.textView5);
        txttype = (TextView) findViewById(R.id.textView2);
        rdoseat = (RadioButton) findViewById(R.id.radioButton2);
        rdobeth = (RadioButton) findViewById(R.id.radioButton3);
        rdgroup =(RadioGroup) findViewById(R.id.radiogroup);
        et=(EditText) findViewById(R.id.textView5);
    }

}

