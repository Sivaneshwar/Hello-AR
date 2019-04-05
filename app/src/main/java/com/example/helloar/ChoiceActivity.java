package com.example.helloar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button b1 = (Button) findViewById(R.id.sofa);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                activityChanger(1);
            }
        });
        Button b2 = (Button) findViewById(R.id.flower);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                activityChanger(2);
            }
        });
        Button b3 = (Button) findViewById(R.id.kitchen);
        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                activityChanger(3);
            }
        });
        Button b4 = (Button) findViewById(R.id.art);
        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                activityChanger(4);
            }
        });

    }

    private void activityChanger(int type){
        Intent intent = new Intent(ChoiceActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
