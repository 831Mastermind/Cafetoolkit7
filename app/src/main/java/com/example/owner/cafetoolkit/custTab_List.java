package com.example.owner.cafetoolkit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class custTab_List extends AppCompatActivity  implements View.OnClickListener {
    private Button buttonModify, buttonBack;

    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_tab__list);

        //test a toast
        Toast.makeText(getApplicationContext(), "Customer Tabs", Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttonModify = (Button) findViewById(R.id.tabM);
        buttonBack = (Button) findViewById(R.id.tabB1);
        //sets onclcik listeners
        buttonModify.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }

    public custTab_List() {
    }

    @Override
    public void onClick(View view) {
        int a = view.getId();
        if (a == R.id.tabB1) { //quit button
            Intent intent = new Intent(custTab_List.this, Functions.class);
            startActivity(intent);
        } else if (a == R.id.tabM) {
            Intent intent = new Intent(custTab_List.this, custTab_Mod.class);
            startActivity(intent);
        } else
            Toast.makeText(getApplicationContext(), "This is a toast", Toast.LENGTH_SHORT).show();


    }


}

