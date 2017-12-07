package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Option1Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name1);
        etPwd = (EditText) findViewById(R.id.et_pwd1);
        etEmail = (EditText) findViewById(R.id.et_email1);
        etPhone = (EditText) findViewById(R.id.et_phone1);
    }

    private void initView(){
        findViewById(R.id.btn_validate1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditText()) {
                    Toast.makeText(Option1Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                    // SnackBar?
                }
            }
        });

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This can be ignored
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This can be ignored
            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText(); // OR validation can be specific (only for this EditText)
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText();
            }
        });
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText();
            }
        });
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText();
            }
        });


//        etPhone.addTextChangedListener(...);
//        etEmail.addTextChangedListener(...);
    }

    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidated = true;
        if ((!etName.getText().toString().matches("^[A-Z,a-z]{1,20}$"))) {
            if (etName.getText().toString().length() > 20) {
                etName.setError("Enter 1-20 Symbol");
            } else {
                etName.setError("Wrong format");
            }
            isValidated = false;
        }
        if ((!etPwd.getText().toString().matches("^[A-Z,a-z,0-9]{8,10}$"))) {
            if (etPwd.getText().toString().length() > 10 || etPwd.getText().toString().length() < 8) {
                etPwd.setError("Enter 8-10 Symbol");
            } else {
                etPwd.setError("Wrong format");
            }
            isValidated = false;
        }
        if ((!etEmail.getText().toString().matches("^[A-Z,a-z,0-9]{1,40}[@]{1}[A-z,a-z,0-9]{1,10}[.]{1}[A-Z,a-z]{3}$"))) {
            if (etEmail.getText().toString().length() > 55) {
                etEmail.setError("Enter 1-55 Symbol");
            } else {
                etEmail.setError("Wrong format");
            }
            isValidated = false;
        }
        if ((!etPhone.getText().toString().matches("^[0]{1}[0-9]{9}$"))) {
            if (etPhone.getText().toString().length() > 10) {
                etPhone.setError("Enter 10 Symbol");
            } else {
                etPhone.setError("Wrong format");
            }
            isValidated = false;
        }
        if (etName.getText().toString().length() == 0) {
            etName.setError("Required");
            isValidated = false;
        }
        if (etPwd.getText().toString().length() == 0) {
            etPwd.setError("Required");
            isValidated = false;
        }
        if (etEmail.getText().toString().length() == 0) {
            etEmail.setError("Required");
            isValidated = false;
        }
        if (etPhone.getText().toString().length() == 0) {
            etPhone.setError("Required");
            isValidated = false;
        }
        // TODO: add your EditText validation here

        return isValidated;
    }
}
