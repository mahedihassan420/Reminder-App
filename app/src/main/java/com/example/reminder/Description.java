package com.example.reminder;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    private static final String SHARED_PREF_NAME = "mnm";
    private static final String KEY_NAME ="nnn" ;
    EditText editText,editText22;
    TextView textView;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        editText = findViewById(R.id.editTextName);
        editText22 = findViewById(R.id.editTextName2);
        textView = findViewById(R.id.textViewName);

        sp= getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        editor = sp.edit();
        String name = sp.getString(KEY_NAME, null);
        if (name != null) {
            textView.setText("Welcome " + name);
        }
        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();
                displayName();
            }
        });
        Button clear=findViewById(R.id.buttonClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
            }
        });




    }




    private void saveName() {
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }


        editor.putString(KEY_NAME, name);


        editor.apply();

        editText.setText("");
    }

    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            textView.setText( name);
        }
    }

}

