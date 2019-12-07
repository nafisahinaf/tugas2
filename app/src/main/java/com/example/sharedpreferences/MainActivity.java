package com.example.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView value;
    EditText edtName,edtPhone,edtAddress;
    Button submit,show,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);
        value = findViewById(R.id.value);
        clear = findViewById(R.id.clear);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clear();
            }
        });


    }
    private void save(){
        if((String.valueOf(edtName.getText()).equals(null)||
                (String.valueOf(edtName.getText()).equals("")||
                        (String.valueOf(edtPhone.getText()).equals(null)||
                                (String.valueOf(edtPhone.getText()).equals("")||
                                        (String.valueOf(edtAddress.getText()).equals(null)||
                                                (String.valueOf(edtAddress.getText()).equals(""))))))))
        {
            Toast.makeText(getApplicationContext(), "Lengkapi Isian Terlebih Dahulu",
                    Toast.LENGTH_SHORT);
        }else{
            String name = String.valueOf(edtName.getText());
            String phone = String.valueOf(edtPhone.getText());
            String address = String.valueOf(edtAddress.getText());
            ContactModel contact = new ContactModel(name + " ", phone+" ", address);
            SharePrefManager.getInstance(MainActivity.this).saveContact(contact);
        }
    }
    private void show(){

    }
    private void clear() {
        SharePrefManager.getInstance(MainActivity.this).clear();
    }
    private void saveArray(){

    }
}
