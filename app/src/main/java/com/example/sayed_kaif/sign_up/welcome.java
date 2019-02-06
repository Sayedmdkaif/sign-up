package com.example.sayed_kaif.sign_up;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class welcome extends AppCompatActivity {

    TextView name,address,email,phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        name=(TextView)findViewById(R.id.name);
        address=(TextView)findViewById(R.id.address);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        password=(TextView)findViewById(R.id.password);


        String name1 = getIntent().getStringExtra("name");
        String address1 = getIntent().getStringExtra("address");
        String email1 = getIntent().getStringExtra("email");
        String phone1 = getIntent().getStringExtra("phone");
        String password1 = getIntent().getStringExtra("password");

        name.setText(name1);
        address.setText(address1);
        email.setText(email1);
        phone.setText(phone1);
        password.setText(password1);


    }
}
