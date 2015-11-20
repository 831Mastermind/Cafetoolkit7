package com.example.owner.cafetoolkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class invMod extends AppCompatActivity  implements View.OnClickListener{
    private Button buttoninvAdd, buttoninvDel,buttoninvBack2, buttoninvSum2;
    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_mod);

        //test a toast
        Toast.makeText(getApplicationContext(), "Modify Inventory", Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttoninvAdd=(Button) findViewById(R.id.invAdd2);
        buttoninvDel=(Button) findViewById(R.id.invDel2);
        buttoninvBack2=(Button) findViewById(R.id.invB2);
        buttoninvSum2=(Button) findViewById(R.id.invSum2);

        //sets onclcik listeners
        buttoninvAdd.setOnClickListener( this);
        buttoninvDel.setOnClickListener( this);
        buttoninvBack2.setOnClickListener( this);
        buttoninvSum2.setOnClickListener( this);

    }
    public invMod(){
    }

    @Override
    public void onClick(View view){
        int a=view.getId();
        if(a==R.id.invB2){ //quit button
            Intent intent = new Intent(invMod.this, invListActivity.class);
            startActivity(intent);
        }
        else if(a==R.id.invAdd2) {
            Toast.makeText(getApplicationContext(),"This will add new item to inventory",Toast.LENGTH_SHORT).show();
        }
        else if(a==R.id.invDel2) {
            Toast.makeText(getApplicationContext(),"This will delete item from inventory",Toast.LENGTH_SHORT).show();
        }
        else if(a==R.id.invSum2) {
            Toast.makeText(getApplicationContext(),"This will sum the value of the item",Toast.LENGTH_SHORT).show();
        }

        else  Toast.makeText(getApplicationContext(),"I'm Dope",Toast.LENGTH_SHORT).show();




    }
   /*Override
    public void onAttatch(Context ctx){
        super.onAttach(ctx);
    }*/
}
