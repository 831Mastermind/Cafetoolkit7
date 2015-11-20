package com.example.owner.cafetoolkit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Functions extends AppCompatActivity  implements View.OnClickListener{
    private Button buttonAddDelete, buttonInventory,buttonTab,buttonQuit,buttonSL;
    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);

        //test a toast
        Toast.makeText(getApplicationContext(),"Choose a Function",Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttonAddDelete=(Button) findViewById(R.id.buttonAD);
        buttonSL=(Button) findViewById(R.id.buttonSL);
        buttonInventory=(Button) findViewById(R.id.buttonInventory);
        buttonTab=(Button)findViewById(R.id.buttonTab);
        buttonQuit=(Button) findViewById(R.id.buttonQuit);
        //sets onclcik listeners
        buttonAddDelete.setOnClickListener( this);
        buttonInventory.setOnClickListener( this);
        buttonSL.setOnClickListener( this);
        buttonTab.setOnClickListener(this);
        buttonQuit.setOnClickListener( this);
    }
    public Functions(){
    }

    @Override
    public void onClick(View view){
        int a=view.getId();
        if(a==R.id.buttonQuit){ //quit button
            Intent intent = new Intent(Functions.this, LoginActivity.class);
            startActivity(intent);
        }
        else if(a==R.id.buttonInventory) {
            Intent intent = new Intent(Functions.this, invListActivity.class);
            startActivity(intent);
        }
        else if(a==R.id.buttonAD) {
            Intent intent = new Intent(Functions.this, addDelete_user.class);
            startActivity(intent);
        }
        else if(a==R.id.buttonTab) {
            Intent intent = new Intent(Functions.this, custTab_List.class);
            startActivity(intent);
        }
        else if(a==R.id.buttonSL) {
            Intent intent = new Intent(Functions.this, shoppingList.class);
            startActivity(intent);
        }


        else  Toast.makeText(getApplicationContext(),"I'm Dope",Toast.LENGTH_SHORT).show();




    }
   /*Override
    public void onAttatch(Context ctx){
        super.onAttach(ctx);
    }*/
}
