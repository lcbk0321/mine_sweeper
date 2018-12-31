package com.example.q.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.nio.file.WatchEvent;

import static com.example.q.minesweeper.GameEngine.difficulty;

public class MainActivity extends Activity {

    static TextView bomb;
    static TextView timer;

    public static int BOMB=10;
    public static int WIDTH=5;
    public static int HEIGHT=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i= getIntent();
        BOMB = i.getExtras().getInt("bomb");
        WIDTH =i.getExtras().getInt("width");
        HEIGHT =i.getExtras().getInt("height");
        bomb = findViewById(R.id.bomb);
        timer= findViewById(R.id.timer);
        Log.e("MainActivity","intentOK");
        Log.e("MainActivity","onCreate");
        GameEngine.getInstance().createGrid(MainActivity.this, BOMB, WIDTH, HEIGHT);

    }

    public TextView getBomb(){
        return bomb;
    }

    public void onResetClicked(View v){
        GameEngine.getInstance().createGrid(MainActivity.this,BOMB, WIDTH, HEIGHT);
    }


}
