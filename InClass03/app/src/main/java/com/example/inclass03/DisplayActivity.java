package com.example.inclass03;

// InClass#03
// DisplayActivity
// Akshay Popli and Neel Solanki
// Assignment Group #14

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    ImageView edt_image;
    TextView full_name;
    TextView edt_gender;
    Button btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("My Profile");

        edt_image = findViewById(R.id.iv_image);
        full_name = findViewById(R.id.tv_name);
        edt_gender = findViewById(R.id.tv_gender);
        btn_edit = findViewById(R.id.btn_edit);
        final Profile p = (Profile) getIntent().getExtras().getSerializable(MainActivity.PROFILE_KEY);


        if(getIntent() != null && getIntent().getExtras() != null){
            //Profile{f_name='asdas', l_name='sadas', selected_gender=male}

            switch (p.selected_gender){
                case "Male":
                    edt_image.setImageDrawable(getDrawable(R.drawable.male));

                    break;
                case "Female":
                    edt_image.setImageDrawable(getDrawable(R.drawable.female));
                    break;

                default:
                    break;
            }

            full_name.setText("Name: " + p.f_name + " " + p.l_name);
            edt_gender.setText(p.selected_gender);
        }

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.PROFILE_KEY, p);
                setResult(RESULT_OK,returnIntent);
                finish();
//                startActivity(returnIntent);

            }
        });
    }


}
