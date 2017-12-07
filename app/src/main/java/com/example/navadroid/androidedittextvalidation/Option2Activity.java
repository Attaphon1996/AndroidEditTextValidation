package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Option2Activity extends AppCompatActivity implements TextWatcher, View.OnClickListener{

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option2);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name2);
        etPwd = (EditText) findViewById(R.id.et_pwd2);
        etEmail = (EditText) findViewById(R.id.et_email2);
        etPhone = (EditText) findViewById(R.id.et_phone2);
    }

    private void initView(){
        // OnClickListener
        findViewById(R.id.btn_validate2).setOnClickListener(this);

        // TextChangedListener
        etName.addTextChangedListener(this);
        etPwd.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);
        etPhone.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // This can be ignored
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // This can be ignored
        validateEditText();
    }

    @Override
    public void afterTextChanged(Editable s) {
        validateEditText();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_validate2) {
            if(validateEditText()) {
                Toast.makeText(this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidated = true;
        //CheckNull
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

        return isValidated;
    }
}
