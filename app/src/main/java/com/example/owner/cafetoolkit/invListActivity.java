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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class invListActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button buttoninvMod1, buttoninvBack1;
    private String jsonResult;
    private String url = "http://athena.ecs.csus.edu/~cafekit/cafeKit/showUser.php";
    private ListView listView;
    //private EditText editName;
    //String person_name=editName.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_list);

        //test a toast
        Toast.makeText(getApplicationContext(),"Inventory List",Toast.LENGTH_SHORT).show();

        //sets the button to a variable
        buttoninvMod1=(Button) findViewById(R.id.invMod1);
        buttoninvBack1=(Button) findViewById(R.id.invBack1);

        //sets onclcik listeners
        buttoninvMod1.setOnClickListener( this);
        buttoninvBack1.setOnClickListener( this);

    }

    public invListActivity(){
    }

    @Override
    public void onClick(View view){
        int a=view.getId();
        if(a==R.id.invBack1){ //quit button
            Intent intent = new Intent(invListActivity.this, Functions.class);
            startActivity(intent);
        }
        else if(a==R.id.invMod1) {
            Intent intent = new Intent(invListActivity.this, invMod.class);
            startActivity(intent);
        }


        else  Toast.makeText(getApplicationContext(),"This is a toast",Toast.LENGTH_SHORT).show();




    }
    private class JsonReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try {
                HttpResponse response = httpclient.execute(httppost);
                jsonResult = inputStreamToString(
                        response.getEntity().getContent()).toString();
            }

            catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            }

            catch (IOException e) {
                // e.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "Error..." + e.toString(), Toast.LENGTH_LONG).show();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(String result) {
            ListDrwaer();
        }
    }// end async task

    public void accessWebService() {
        JsonReadTask task = new JsonReadTask();
        // passes values for the urls string array
        task.execute(new String[]{url});
    }

    // build hash set for list view
    public void ListDrwaer() {
        List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

        try {
            JSONObject jsonResponse = new JSONObject(jsonResult);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("Users");

            for (int i = 0; i < jsonMainNode.length(); i++) {
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                String first = jsonChildNode.optString("first_name");
                String last = jsonChildNode.optString("last_name");
                String email = jsonChildNode.optString("email");
                String user = jsonChildNode.optString("username");
                String pass = jsonChildNode.optString("password");
                String role = jsonChildNode.optString("role");
                //String number = jsonChildNode.optString("employee no");
                String outPut = "First Name:  "+first +"\nLast Name:  "+last +"\nEmail:  "+email +"\nUsername:  "+user +"\nPassword:  "+pass +"\nRole:  "+role +"\n";
                employeeList.add(createEmployee("Users", outPut));
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error" + e.toString(),
                    Toast.LENGTH_SHORT).show();
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList,
                android.R.layout.simple_list_item_1,
                new String[] { "Users" }, new int[] { android.R.id.text1 });
        listView.setAdapter(simpleAdapter);
        Toast.makeText(getApplication(), "Users", Toast.LENGTH_SHORT).show();

    }

    private HashMap<String, String> createEmployee(String first, String last) {
        HashMap<String, String> employeeNameNo = new HashMap<String, String>();
        employeeNameNo.put(first, last);
        return employeeNameNo;
    }
}
