package com.example.owner.cafetoolkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class custTab_Mod extends AppCompatActivity  implements View.OnClickListener {
    private Button buttontabAdd2, buttontabBack2, buttontabDel2, buttontabSum2;

    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_tab__mod);

        //test a toast
        Toast.makeText(getApplicationContext(), "Modify Customer Tabs", Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttontabAdd2 = (Button) findViewById(R.id.tabAdd2);
        buttontabBack2 = (Button) findViewById(R.id.tabBack2);
        buttontabDel2 = (Button) findViewById(R.id.tabDel2);
        buttontabSum2 = (Button) findViewById(R.id.tabSum2);
        //sets onclcik listeners
        buttontabAdd2.setOnClickListener(this);
        buttontabSum2.setOnClickListener(this);
        buttontabBack2.setOnClickListener(this);
        buttontabDel2.setOnClickListener(this);
    }

    public custTab_Mod() {
    }

    @Override
    public void onClick(View view) {
        int a = view.getId();
        if (a == R.id.tabBack2) { //quit button
            Intent intent = new Intent(custTab_Mod.this, custTab_List.class);
            startActivity(intent);
        }
        else if (a == R.id.tabAdd2) {
            Toast.makeText(getApplicationContext(), "This will add a new Customer.", Toast.LENGTH_SHORT).show();
        }
        else if (a == R.id.tabDel2) {
            Toast.makeText(getApplicationContext(), "This will delete a Customer.", Toast.LENGTH_SHORT).show();
        }
        else if (a == R.id.tabSum2) {
            Toast.makeText(getApplicationContext(), "This will total the values.", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getApplicationContext(), "I'm Dope", Toast.LENGTH_SHORT).show();


    }
}
