package com.example.sayed_kaif.sign_up;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,15}" +               //at least 4 characters
                    "$");
    boolean result=false;
EditText name,address,email,phone,password;
boolean name_status=false,address_status=false,email_status=false,phone_status=false,password_status=false,digit=false,uppercase=false,lowercase=false;
Button signup;
char character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);


        signup = (Button) findViewById(R.id.sign_in);
        signup.setVisibility(View.INVISIBLE);


        if(name.equals("") || address.equals("") || email.equals("")|| phone.equals("")||password.equals(""))
        {
            signup.setVisibility(View.INVISIBLE);
            name_status=false;
                    address_status=false;
                    email_status=false;
                    phone_status=false;
                    password_status=false;

            show_button();
        }



    name.addTextChangedListener(new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().equals("Please enter name")) {
                name.setError("");
                name_status = false;
               signup.setVisibility(View.INVISIBLE);
               // signup.setEnabled(false);
                show_button();
            }
    }


        @Override
        public void afterTextChanged(Editable s) {

            if (s.toString().length() < 4) {
                name_status=false;
          name.setError("Please enter name atleast 4 character");
            }
            else
            {
                name_status=true;
                show_button();

            }

        }
    });



    address.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            if (s.toString().equals("")) {
               address.setError("Please enter address");
                address_status = false;
                signup.setVisibility(View.INVISIBLE);
                // signup.setEnabled(false);
                show_button();
            }


                    }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.toString().length() < 10) {
                address_status=false;
           address.setError("Please enter address atleast 10 character");
            }
            else
            {
                address_status=true;
                show_button();
            }
        }
    });



email.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().equals("")) {
            email.setError("Please enter email");
            email_status = false;
            signup.setVisibility(View.INVISIBLE);
            // signup.setEnabled(false);
            show_button();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr =  email.getText().toString();
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);


        if (!matcher.matches()) {
            email_status = false;
            show_button();
            email.setError("Email is not correct");
        }
        else
        {
            email_status=true;
            show_button();


        }

        }
});



phone.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().equals("")) {

            phone.setError("Please enter phone");
            phone_status = false;
            signup.setVisibility(View.INVISIBLE);
            // signup.setEnabled(false);
            show_button();
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (s.toString().length() < 12)
        {
            phone_status = false;
      phone.setError("Please enter 10 digit phone number with country code");
        }

        else {
            phone_status = true;
            show_button();


        }
    }
});


password.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().equals("")) {
            password.setError("Please enter password");
            password_status = false;
            signup.setVisibility(View.INVISIBLE);
            show_button();
        }




    }

    @Override
    public void afterTextChanged(Editable s) {

        if (password.getText().toString().equals("")) {
            signup.setVisibility(View.INVISIBLE);
            password.setError("Please enter password");
        }
        if(password.getText().toString().length()<8)
        {
            signup.setVisibility(View.INVISIBLE);
            password.setError("Please enter atleast 8 character password");
        }
        if(password.getText().toString().length()>15)
        {
            signup.setVisibility(View.INVISIBLE);
            password.setError("Max password length should be 15 character");
        }
        if (!PASSWORD_PATTERN.matcher(password.getText().toString().trim()).matches()) {
            signup.setVisibility(View.INVISIBLE);
           password.setError("Please enter strong password");

        }
        else
        {
            signup.setVisibility(View.VISIBLE);
            password_status=true;
            show_button();
        }





        }




});


}


private  void show_button()
{

    if(name_status && address_status && email_status && phone_status && password_status ) {
        signup.setVisibility(View.VISIBLE);

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
   //  result = data.insertData(name.getText().toString(),address.getText().toString(),email.getText().toString(),phone.getText().toString(), password.getText().toString());

               Organization organization = new Organization();
              // organization.setId(1);
               organization.setName(name.getText().toString());
               organization.setAddress(address.getText().toString());
               organization.setPhone(phone.getText().toString());
               organization.setEmail(email.getText().toString());
               organization.setPassword(password.getText().toString());

               organization.save();
               Toast.makeText(MainActivity.this, "Successfully Sign up user", Toast.LENGTH_SHORT).show();




                   Intent intent = new Intent(MainActivity.this,welcome.class);
                   intent.putExtra("name", name.getText().toString());
                   intent.putExtra("address", address.getText().toString());
                   intent.putExtra("email", email.getText().toString());
                   intent.putExtra("phone", phone.getText().toString());
                   intent.putExtra("password", password.getText().toString());

                   startActivity(intent);





           }


       });


    }

    else
        signup.setVisibility(View.INVISIBLE);



}








    }
