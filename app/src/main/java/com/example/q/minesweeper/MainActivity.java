package com.example.q.minesweeper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.q.minesweeper.GameEngine.difficulty;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final RadioGroup difficulty = findViewById(R.id.difficulty);
        final RadioButton easy = findViewById(R.id.easy);
        final RadioButton medium = findViewById(R.id.medium);
        final RadioButton hard = findViewById(R.id.hard);
        final LinearLayout game = findViewById(R.id.game);
        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(easy.isChecked()){
                    difficulty.setVisibility(View.INVISIBLE);
                    GameEngine.getInstance().createGrid(MainActivity.this, 10, 9, 9);
                    game.setVisibility(View.VISIBLE);
                }else if (medium.isChecked()) {
                    difficulty.setVisibility(View.INVISIBLE);
                    GameEngine.getInstance().createGrid(MainActivity.this, 20, 12, 12);
                    game.setVisibility(View.VISIBLE);
                }else if (hard.isChecked()){
                    difficulty.setVisibility(View.INVISIBLE);
                    GameEngine.getInstance().createGrid(MainActivity.this, 40, 16, 16);
                    game.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "난이도를 선택하세요", Toast.LENGTH_LONG).show();
                }
            }
        }
        );*/

        Log.e("MainActivity","onCreate");
        GameEngine.getInstance().createGrid(MainActivity.this);

    }

    public void onResetClicked(View v){
       // RadioGroup difficulty = findViewById(R.id.difficulty);
        LinearLayout game = findViewById(R.id.game);
        //difficulty.setVisibility(View.VISIBLE);
        game.setVisibility(View.INVISIBLE);
    }
}
