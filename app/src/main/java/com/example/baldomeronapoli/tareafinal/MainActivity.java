package com.example.baldomeronapoli.tareafinal;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.btnSend);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final TextView tvDate = (TextView) findViewById(R.id.tvDate);
        final TextView etEmail = (TextView) findViewById(R.id.etEmail);
        final TextView etTelefono = (TextView) findViewById(R.id.etTelefono);
        final TextView etDetail = (TextView) findViewById(R.id.etDetail);

        ImageView myImg = (ImageView) findViewById(R.id.ivDatePicker);
        myImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StringFormatInvalid")
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etTelefono.getText().toString();
                String detail = etDetail.getText().toString();
                String date = tvDate.getText().toString();

                if(name.matches("")){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.name_null), Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                    snackbar.show();
                }
                else if (date.matches("") ||  date.matches(getResources().getString(R.string.dateBirthDay))){
                    Snackbar snackbar = Snackbar
                            .make(v, getResources().getString(R.string.date_null), Snackbar.LENGTH_LONG);
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
            tvDate.setText(request.getString("date"));
        }


    }

    private void showDatePickerDialog() {
        final TextView tvDate = (TextView) findViewById(R.id.tvDate);

        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                tvDate.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public static class DatePickerFragment extends DialogFragment {

        private DatePickerDialog.OnDateSetListener listener;

        public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
            DatePickerFragment fragment = new DatePickerFragment();
            fragment.setListener(listener);
            return fragment;
        }

        public void setListener(DatePickerDialog.OnDateSetListener listener) {
            this.listener = listener;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), listener, year, month, day);
        }

    }
}
