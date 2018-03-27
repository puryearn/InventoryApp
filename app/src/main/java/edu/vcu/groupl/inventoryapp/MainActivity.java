package edu.vcu.groupl.inventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nathan on 3/27/18.
 */

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.Blogin){
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)) {
                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("Username", str);
                startActivity(i);
            } else {
                // popup message
                Toast temp = Toast.makeText(MainActivity.this, "Username and password don't match!", Toast.LENGTH_LONG);
                temp.show();
            }
        }
        if(v.getId() == R.id.Bsignup){
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }
}
