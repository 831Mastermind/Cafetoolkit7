package com.example.owner.cafetoolkit;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class addDelete_user extends AppCompatActivity implements View.OnClickListener{
    private Button buttonadAdd1, buttonadDel1,buttonadBack1,buttonadView;
    EditText textadFirst, textadLast, textadEmail, textadUser, textadPassword, textadRole;
    String first,last,email,user,pass,role;
    private static final String insertUser = "http://athena.ecs.csus.edu/~cafekit/cafeKit/adUser.php";
    private static final String deleteUser = "http://athena.ecs.csus.edu/~cafekit/cafeKit/deleteUser.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete_user);

        Toast.makeText(getApplicationContext(),"Add/Delete Employee Account",Toast.LENGTH_SHORT).show();
        //sets the button to a variable
        buttonadView=(Button) findViewById(R.id.adView);
        textadFirst = (EditText)findViewById(R.id.adFirst);
        textadRole = (EditText)findViewById(R.id.adRole);
        textadLast = (EditText)findViewById(R.id.adLast);
        textadEmail = (EditText)findViewById(R.id.adEmail);
        textadUser = (EditText)findViewById(R.id.adUser);
        textadPassword = (EditText)findViewById(R.id.adPassword);
        buttonadAdd1=(Button) findViewById(R.id.adAdd1);
        buttonadDel1=(Button) findViewById(R.id.adDel1);
        buttonadBack1=(Button) findViewById(R.id.adBack1);
        //sets onclcik listeners
        buttonadAdd1.setOnClickListener(this);
        buttonadView.setOnClickListener(this);
        buttonadDel1.setOnClickListener(this);
        buttonadBack1.setOnClickListener(this);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }


/*    private void registerUser(){
        first= textadFirst.getText().toString().trim().toLowerCase();
        last= textadLast.getText().toString().trim().toLowerCase();
        email= textadEmail.getText().toString().trim().toLowerCase();
        user= textadUser.getText().toString().trim().toLowerCase();
        pass= textadPassword.getText().toString().trim().toLowerCase();
        role= textadPassword.getText().toString().trim().toLowerCase();
        register(first, last, email, user, pass, role);
    }

    private void register(String first,String last,String email,String user, String pass, String role){
        class RegisterUser extends AsyncTask<String, Void, String>{
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(addDelete_user.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("first",params[1]);
                data.put("last",params[2]);
                data.put("email",params[3]);
                data.put("username",params[4]);
                data.put("password",params[5]);
                data.put("role",params[6]);



                String result = ruc.sendPostRequest(insertUser,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(first,last,email,user,pass,role);
    }
*/
    @Override
    public void onClick(View view){
        int a=view.getId();
        if(a==R.id.adBack1){ //quit button
            Intent intent = new Intent(addDelete_user.this, Functions.class);
            startActivity(intent);
        }
        else if(a==R.id.adView){ //quit button
            Intent intent = new Intent(addDelete_user.this, showUser.class);
            startActivity(intent);
        }
        else if(a==R.id.adDel1){

            StringRequest deleteRequest = new StringRequest(Request.Method.POST, deleteUser, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }

            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> data = new HashMap<String,String>();
                    data.put("first_name",textadFirst.getText().toString());
                    data.put("last_name",textadLast.getText().toString());
                    data.put("email",textadEmail.getText().toString());
                    data.put("username",textadUser.getText().toString());
                    data.put("password",textadPassword.getText().toString());
                    data.put("role",textadRole.getText().toString());

                    return data;
                }
            };
            requestQueue.add(deleteRequest);

        }
        else if(a==R.id.adAdd1){

            StringRequest addRequest = new StringRequest(Request.Method.POST, insertUser, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }

            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> data = new HashMap<String,String>();
                    data.put("first_name",textadFirst.getText().toString());
                    data.put("last_name",textadLast.getText().toString());
                    data.put("email",textadEmail.getText().toString());
                    data.put("username",textadUser.getText().toString());
                    data.put("password",textadPassword.getText().toString());
                    data.put("role",textadRole.getText().toString());

                    return data;
                }
            };
            requestQueue.add(addRequest);

           /* textadLast.setText("");
            textadEmail.setText("");
            textadUser.setText("");
            textadPassword.setText("");
            textadFirst.setText("");
            textadRole.setText("");
            */
            };
            //registerUser();
            //Toast.makeText(getApplicationContext(),"This will add a user",Toast.LENGTH_SHORT).show();
      //  else  Toast.makeText(getApplicationContext(),"I'm Dope",Toast.LENGTH_SHORT).show();

    }






    }




