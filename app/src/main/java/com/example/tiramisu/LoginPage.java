package com.example.tiramisu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    Button login,signup;
    EditText un,pw;
    TextView labeltext;
    String user ;
    String pass ;
    int clickcount = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        login = (Button) findViewById(R.id.button);
        signup = (Button) findViewById(R.id.button3);
        un = (EditText)findViewById(R.id.username);
        pw = (EditText)findViewById(R.id.password);
        labeltext = (TextView)findViewById(R.id.labeltext);


        Intent intentfromreg = getIntent();
        user = intentfromreg.getStringExtra("username");
        pass = intentfromreg.getStringExtra("password");
        pw.setEnabled(false);
        un.setText(user);
        pw.setText(pass);
       /* USING ANONYMOUS INNER CLASS*/
     /*   login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomePage.class);
                startActivity(i);

            }
        });*/

        /* USING XML*/
/*
        public void login(View) {
            Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_LONG).show();
        }
    }
}*/


        /*implement listeners*/
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
         login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String uname = un.getText().toString();
        String pword = pw.getText().toString();
        if(user.equals(uname)&& pass.equals(pword)) {

            Intent i = new Intent(getApplicationContext(), HomePage.class);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
            clickcount--;

            if(clickcount == 0){
                login.setEnabled(false);
                labeltext.setText("LOGIN BLOCKED");
                labeltext.setTextColor(Color.RED);

            }
        }
    }

    public void Register(){
        Intent sign = new Intent(getApplicationContext(),Register.class);
        startActivity(sign);
    }
}

