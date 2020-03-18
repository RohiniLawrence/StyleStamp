package com.example.stylestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editPassword, editNewPassword, editRetypePassword;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initialize();
    }

    private void initialize() {
        editPassword = findViewById(R.id.editPassword);
        editNewPassword = findViewById(R.id.editNewPassword);
        editRetypePassword = findViewById(R.id.editRetypepassword);
        btnUpdate = findViewById(R.id.btnPasswordUpdate);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(editNewPassword.getText().toString().equals(editRetypePassword.getText().toString())){

        }else{
            Toast.makeText(this,"New Password do not match with retype password",Toast.LENGTH_SHORT).show();
        }
    }
}
