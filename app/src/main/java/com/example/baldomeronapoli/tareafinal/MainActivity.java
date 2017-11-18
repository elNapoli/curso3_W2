package com.example.baldomeronapoli.tareafinal;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailContact.class);
                intent.putExtra("name",etName.getText().toString());
                intent.putExtra("email",etEmail.getText().toString());
                intent.putExtra("phone",etTelefono.getText().toString());
                intent.putExtra("detail",etDetail.getText().toString());
                intent.putExtra("date",etDate.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
    public void datePicker(View view){

    }
}
