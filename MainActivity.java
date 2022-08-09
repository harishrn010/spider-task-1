package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private String selected1,selected2,selected3;
    private int input2;
    private TextView error1,error2;
    private Spinner spinner1,spinner2,spinner3;
    private ArrayAdapter<CharSequence> adapter5,adapter6,adapter7,adapter8,adapter9;


    Button button1;
    EditText input;
    EditText output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner11);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.array_spinner1, R.layout.spinner1_layout);
        adapter5.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter5);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                spinner2 = findViewById(R.id.spinner22);
                selected1 = spinner1.getSelectedItem().toString();


                int parent_id = parent.getId();

                if(parent_id==R.id.spinner11) {

                    switch (selected1) {
                        case "Temperature":
                            adapter6 = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_spinner2, R.layout.spinner2_layout);
                            spinner2.setAdapter(adapter6);
                            spinner3.setAdapter(adapter6);
                            selected2 = spinner2.getSelectedItem().toString();
                            input = (EditText) findViewById(R.id.input1);
                            button1 = (Button) findViewById(R.id.button);
                            button1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    input2 = Integer.parseInt(input.getText().toString());
                                    switch (selected2){
                                        case "Fahrenheit":
                                            double input3= (input2-32)*0.555;
                                    }

                                }
                            });


                    }
                    switch(selected1) {
                        case "Length":
                            adapter7 = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_spinner3, R.layout.spinner3_layout);
                            spinner2.setAdapter(adapter7);
                            spinner3.setAdapter(adapter7);

                    }
                    switch (selected1){
                        case "Weight":
                            adapter8 = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_spinner4, R.layout.spinner4_layout);
                            spinner2.setAdapter(adapter8);
                            spinner3.setAdapter(adapter8);
                    }
                    switch (selected1){
                        case "Speed":
                            adapter9 = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_spinner5, R.layout.spinner5_layout);
                            spinner2.setAdapter(adapter9);
                            spinner3.setAdapter(adapter9);
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Choose an option", Toast.LENGTH_SHORT).show();

            }
        });


        spinner3 = findViewById(R.id.spinner33);




    }
}
