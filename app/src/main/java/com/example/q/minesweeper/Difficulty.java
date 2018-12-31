package com.example.q.minesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        final RadioButton easy = findViewById(R.id.easy);
        final RadioButton medium = findViewById(R.id.medium);
        final RadioButton hard = findViewById(R.id.hard);
        Button check = findViewById(R.id.check);
        final Intent intent = new Intent(this, MainActivity.class);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(easy.isChecked()){
                    intent.putExtra("bomb", 10);
                    intent.putExtra("width", 9);
                    intent.putExtra("height", 9);
                    startActivityForResult(intent, 1);
                }else if (medium.isChecked()) {
                    intent.putExtra("bomb", 20);
                    intent.putExtra("width", 13);
                    intent.putExtra("height", 13);
                    startActivityForResult(intent, 1);
                }else if (hard.isChecked()){
                    intent.putExtra("bomb", 40);
                    intent.putExtra("width", 16);
                    intent.putExtra("height", 16);
                    startActivityForResult(intent, 1);
                }else{
                    Toast.makeText(getApplicationContext(),"난이도를 선택하세요", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}
