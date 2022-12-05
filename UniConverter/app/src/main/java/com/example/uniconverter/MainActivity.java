package com.example.uniconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String lengthunits[]={"cm","m","km"};
    String unitchoice="cm";
    double currentinput=0;
    double cmval=0;
    double mval=0;
    double kmval=0;
    EditText input;
    TextView cmtxt;
    TextView mtxt;
    TextView kmtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText) findViewById(R.id.edit_text_1);
        cmtxt=(TextView) findViewById(R.id.text_view_1);
        mtxt=(TextView) findViewById(R.id.text_view_2);
        kmtxt=(TextView) findViewById(R.id.text_view_3);
        //create spinner for drowndown
        spinner=(Spinner) findViewById(R.id.spinner_1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lengthunits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                unitchoice=lengthunits[position];
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                currentinput=Double.parseDouble(input.getText().toString());
                convert();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public void convert()
    {
        switch(unitchoice)
        {
            case "cm":
                cmval=currentinput;
                mval=currentinput*0.01;
                kmval=currentinput*0.00001;
            case "m":
                cmval=currentinput*100;
                mval=currentinput;
                kmval=currentinput*0.001;
            case "km":
                cmval=currentinput*100000;
                mval=currentinput*1000;
                kmval=currentinput;
            default:
                break;
        }
        cmtxt.setText(cmval+"cm");
        mtxt.setText(mval+"m");
        kmtxt.setText(kmval+"km");
    }


}