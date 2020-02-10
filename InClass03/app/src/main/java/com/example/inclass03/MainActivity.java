package com.example.inclass03;


// InClass#03
// MainActivity
// Akshay Popli and Neel Solanki
// Assignment Group #14

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    RadioGroup radio_gender;
    RadioButton radio_male;
    RadioButton radio_female;
    ImageView iv_gender;
    EditText f_name;
    EditText l_name;
    Button button_save;
    String str_gender = "";
    int REQ_CODE = 200;

    static String PROFILE_KEY = "PROFILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        f_name = findViewById(R.id.et_first);
        l_name = findViewById(R.id.et_last);
        radio_gender = findViewById(R.id.radio_gender);
        radio_male = findViewById(R.id.radio_male);
        radio_female = findViewById(R.id.radio_female);
        iv_gender = findViewById(R.id.iv_gender);
        button_save = findViewById(R.id.btn_save);

        radio_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_male:
                        iv_gender.setImageDrawable(getDrawable(R.drawable.male));
                        str_gender = "Male";
                        break;
                    case R.id.radio_female:
                        iv_gender.setImageDrawable(getDrawable(R.drawable.female));
                        str_gender = "Female";
                        break;

                    default:
                        break;
                }
            }
        });


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String first = f_name.getText().toString();
                final String last = l_name.getText().toString();

                if (f_name.getText().toString().trim().equals("")) {
                    f_name.setError("Invalid Input");
                } else if (l_name.getText().toString().trim().equals("")) {
                    l_name.setError("Invalid Input");
                } else if (str_gender.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else {
                    Profile profile = new Profile(first, last, str_gender);
                    Intent intent = new Intent(getBaseContext(), DisplayActivity.class);
                    intent.putExtra(PROFILE_KEY, profile);
                    startActivityForResult(intent, REQ_CODE);
                }


            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQ_CODE){
            if(resultCode == RESULT_OK && data.getExtras().containsKey(PROFILE_KEY)){
//                String rt = (String) data.getExtras().getSerializable(PROFILE_KEY);
//                Log.d("Data Returned", rt);
                Toast.makeText(this, data.getExtras().getString(PROFILE_KEY), Toast.LENGTH_SHORT).show();
            }else {
                Log.d("else", " dask");
            }
        }
    }
}
