package com.example.baldomeronapoli.tareafinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.btnSend);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final TextView etDate = (TextView) findViewById(R.id.etDate);
        final TextView etEmail = (TextView) findViewById(R.id.etEmail);
        final TextView etTelefono = (TextView) findViewById(R.id.etTelefono);
        final TextView etDetail = (TextView) findViewById(R.id.etDetail);

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StringFormatInvalid")
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etTelefono.getText().toString();
                String detail = etDetail.getText().toString();
                String date = etDate.getText().toString();

                if(name.matches("")){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.name_null), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();
                }
                else if (phone.matches("")){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.phone_null), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();

                }
                else if (email.matches("")){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.email_null), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();
                }

                else if (date.matches("")){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.date_null), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,DetailContact.class);
                    intent.putExtra("name",name);
                    intent.putExtra("email",email);
                    intent.putExtra("phone",phone);
                    intent.putExtra("detail",detail);
                    intent.putExtra("date",date);
                    startActivity(intent);
                    finish();
                }

            }
        });

        Bundle request = getIntent().getExtras();
        if(request != null){
            etName.setText(request.getString("name"));
            etEmail.setText(request.getString("email"));
            etTelefono.setText(request.getString("phone"));
            etDetail.setText(request.getString("detail"));
            etDate.setText(request.getString("date"));
        }


    }
    public void datePicker(View view){

    }
}
