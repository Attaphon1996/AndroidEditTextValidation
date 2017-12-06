package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Option3Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name3);
        etPwd = (EditText) findViewById(R.id.et_pwd3);
        etEmail = (EditText) findViewById(R.id.et_email3);
        etPhone = (EditText) findViewById(R.id.et_phone3);
    }

    private void initView(){
        // OnClickListener
        findViewById(R.id.btn_validate3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditText()){
                    Toast.makeText(Option3Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TextChangedListener
        etName.addTextChangedListener(new TextValidator(etName) {
            @Override
            public void validate(TextView textView, String text) {
                if ((!etName.getText().toString().matches("^[A-Z,a-z]{1,20}$"))) {
                    if (etName.getText().toString().length() > 20) {
                        etName.setError("Enter 1-20 Symbol");
                    } else {
                        etName.setError("Wrong format");
                    }
                }
                if (etName.getText().toString().length() == 0) {
                    etName.setError("Required");
                }
            }
        });

        etPwd.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                if ((!etPwd.getText().toString().matches("^[A-Z,a-z,0-9]{8,10}$"))) {
                    if (etPwd.getText().toString().length() > 10 || etPwd.getText().toString().length() < 8) {
                        etPwd.setError("Enter 8-10 Symbol");
                    } else {
                        etPwd.setError("Wrong format");
                    }
                }
                if (etPwd.getText().toString().length() == 0) {
                    etPwd.setError("Required");
                }
            }
        });
        etEmail.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                if ((!etEmail.getText().toString().matches("^[A-Z,a-z,0-9]{1,40}[@]{1}[A-z,a-z,0-9]{1,10}[.]{1}[A-Z,a-z]{3}$"))) {
                    if (etEmail.getText().toString().length() > 55) {
                        etEmail.setError("Enter 1-55 Symbol");
                    } else {
                        etEmail.setError("Wrong format");
                    }
                }
                if (etEmail.getText().toString().length() == 0) {
                    etEmail.setError("Required");
                }
            }
        });
        etPhone.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                if ((!etPhone.getText().toString().matches("^[0]{1}[8]{1}[0-9]{8}$"))) {
                    if (etPhone.getText().toString().length() > 10) {
                        etPhone.setError("Enter 10 Symbol");
                    } else {
                        etPhone.setError("Wrong format");
                    }
                }
                if (etPhone.getText().toString().length() == 0) {
                    etPhone.setError("Required");
                }
            }
        });

        //etEmail.addTextChangedListener(...);
        //etPhone.addTextChangedListener(...);
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
        if ((!etPhone.getText().toString().matches("^[0]{1}[8]{1}[0-9]{8}$"))) {
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
