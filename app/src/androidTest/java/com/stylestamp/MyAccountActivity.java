package com.example.stylestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Model.User;

import java.util.Iterator;
import java.util.List;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName,editEmail,editPhoneNumber,editDeliveryInfo,editPaymentInfo;
    List<User> users;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        //Initialize components
        initiallize();

        //Click on back , this method will be called
        update();
    }

    private void initiallize() {
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhoneNumber = findViewById(R.id.editphonenumber);
        editDeliveryInfo = findViewById(R.id.editDeliveryInfo);
        editPaymentInfo = findViewById(R.id.edittxtPaymentInfo);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        //getting data from API and set in object
        User objUser = new User("Priyank","P@gmail.com","9999999999","h1t4b5","cash");
        users.add(objUser);
        editName.setText(objUser.getName());
        editEmail.setText(objUser.getEmail());
        editPhoneNumber.setText(objUser.getPhoneNumber());
        editDeliveryInfo.setText(objUser.getDeliveryInfo());
        editPaymentInfo.setText(objUser.getPaymentMethod());
    }

    private void update() {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String phoneNumber = editPhoneNumber.getText().toString();
        String deliveryInfo = editDeliveryInfo.getText().toString();
        String paymentMethod = editPaymentInfo.getText().toString();
        User objUpdate = new User(name,email,phoneNumber,deliveryInfo,paymentMethod);

        int size = users.size();

        for(int i=0;i<size;i++) {
            if(users.get(i).getEmail().equalsIgnoreCase(email)) {
                users.set(i,objUpdate);
            }
        }
    }


    @Override
    public void onClick(View v) {
        update();
        this.finish();
    }
}
