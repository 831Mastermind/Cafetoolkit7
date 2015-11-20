package com.example.owner.cafetoolkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class shoppingList extends AppCompatActivity  implements View.OnClickListener {
    private Button buttonslAdd1, buttonslDel1, buttonslBack1;

    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //test a toast
        Toast.makeText(getApplicationContext(), "Shopping List", Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttonslAdd1 = (Button) findViewById(R.id.slAdd1);
        buttonslBack1 = (Button) findViewById(R.id.slBack1);
        buttonslDel1 = (Button) findViewById(R.id.slDel1);

        //sets onclcik listeners
        buttonslAdd1.setOnClickListener(this);
        buttonslDel1.setOnClickListener(this);
        buttonslBack1.setOnClickListener(this);

    }

    public shoppingList() {
    }

    @Override
    public void onClick(View view) {
        int a = view.getId();
        if (a == R.id.slBack1) { //quit button
            Intent intent = new Intent(shoppingList.this, Functions.class);
            startActivity(intent);
        } else if (a == R.id.slAdd1) { //quit button
            Toast.makeText(getApplicationContext(), "Adds item to list", Toast.LENGTH_SHORT).show();
        }else if (a == R.id.slDel1) { //quit button
            Toast.makeText(getApplicationContext(), "Deletes item from list", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "I'm Dope", Toast.LENGTH_SHORT).show();


    }
}
