package com.example.sayan.mydemofragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTask);
        textView = (TextView) findViewById(R.id.textViewTask);
        databaseHelper = new MyDatabaseHelper(this,null,null,1);

        printDB();
    }
    public void addButtonClicked(View view){

        Tasks tasks = new Tasks(editText.getText().toString());
        databaseHelper.addTask(tasks);
        printDB();
    }
    public void removeButtonClicked(View view){

        String input = editText.getText().toString();
        databaseHelper.removeTasks(input);
        printDB();
    }
    public void printDB(){
        String dbString = databaseHelper.databasetostring();
        textView.setText(dbString);
    }
}
