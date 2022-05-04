package com.example.tiramisu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    RadioGroup gender;
    CheckBox c1,c2,c3,c4;
    String states[] = {"-Select State-","Kerala","TamilNadu","Karnataka","Goa","Rajastan","Punjab"};
    Spinner sp;
    /*ArrayList district = new ArrayList();*/
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //spinner using array list
     /*   district.add("Ernakulam");
        district.add("idukki");
        district.add("Thiruvanathapuram");*/
        sp = (Spinner)findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,states);
        sp.setAdapter(arrayAdapter);



        // click on spinner //
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("-Select State-")){

                }else {
                    Toast.makeText(getApplicationContext(), states[i], Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button reg = (Button) findViewById(R.id.button2);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eu = (EditText) findViewById(R.id.Uname);
                EditText ep = (EditText) findViewById(R.id.pwd);

                String user = eu.getText().toString();
                String pwd = ep.getText().toString();

                Intent i = new Intent(getApplicationContext(),LoginPage.class);
                i.putExtra("username",user);
                i.putExtra("password",pwd);
                startActivity(i);
            }
        });



        gender = (RadioGroup) findViewById(R.id.rg);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                String value = rb.getText().toString();
                Toast.makeText(getApplicationContext(), "Gender is "+value,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void register(View view) {
        boolean checkedcheckbox = ((CheckBox)view).isChecked() ;


        String lang ="";
        switch (view.getId()){
            case R.id.checkBox4:
                lang = checkedcheckbox ? "Malayalam selected" : "Malayalam deselected";
                break;
            case R.id.checkBox5:
                lang = checkedcheckbox ? "English selected" : "English deselected";
                break;
            case R.id.checkBox6:
                lang = checkedcheckbox ? "Hindi selected" : "Hindi deselected";
                break;
            case R.id.checkBox7:
                lang = checkedcheckbox ? "Tamil selected" : "Tamil deselected";
                break;
        }

       Toast.makeText(getApplicationContext(),"Languages Known "+lang,Toast.LENGTH_LONG).show();
    }
}