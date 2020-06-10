package com.example.lab3java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public EditText edit;
    public TextView txtShow;
    private Intent intentOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.throwPassword);
        txtShow = findViewById(R.id.textBox);
    }

    public void output(View view) {
        if(intentOutput == null)
            intentOutput = new Intent(this, Output.class);
        startActivity(intentOutput);
    }

    public void write (View view){
        String myTxt = edit.getText().toString();
        try {
            FileOutputStream fileOutput = openFileOutput("example.txt", MODE_PRIVATE);

            fileOutput.write(myTxt.getBytes());
            fileOutput.close();
            edit.setText("");
                if(myTxt.toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Nothing Entered", Toast.LENGTH_LONG).show();
            }else {
                    Toast.makeText(MainActivity.this, "Password added", Toast.LENGTH_LONG).show();
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
