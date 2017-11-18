package com.example.baldomeronapoli.tareafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);

        Bundle request = getIntent().getExtras();

        final TextView tvName = (TextView) findViewById(R.id.tvName);
        final TextView tvDateBirthday = (TextView) findViewById(R.id.tvDateBirthday);
        final TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        final TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        final TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        Button btnEdit = (Button) findViewById(R.id.btnEdit);


        tvName.setText(request.getString("name"));
        tvDateBirthday.setText(request.getString("date"));
        tvPhone.setText(request.getString("phone"));
        tvEmail.setText(request.getString("email"));
        tvDetail.setText(request.getString("detail"));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailContact.this,MainActivity.class);
                intent.putExtra("name",tvName.getText().toString());
                intent.putExtra("email",tvEmail.getText().toString());
                intent.putExtra("phone",tvPhone.getText().toString());
                intent.putExtra("detail",tvDetail.getText().toString());
                intent.putExtra("date",tvDateBirthday.getText().toString());
                startActivity(intent);
                finish();

            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetailContact.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);


    }
}
