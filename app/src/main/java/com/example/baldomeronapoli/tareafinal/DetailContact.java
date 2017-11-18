package com.example.baldomeronapoli.tareafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);

        Bundle request = getIntent().getExtras();

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvDateBirthday = (TextView) findViewById(R.id.tvDateBirthday);
        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);

        tvName.setText(request.getString("name"));
        tvDateBirthday.setText(request.getString("date"));
        tvPhone.setText(request.getString("phone"));
        tvEmail.setText(request.getString("email"));
        tvDetail.setText(request.getString("detail"));



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
