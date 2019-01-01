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

import com.airbnb.lottie.LottieAnimationView;

import java.nio.file.WatchEvent;


public class MainActivity extends Activity {

    static TextView bomb;
    static TextView win;
    static TextView lose;
    static LottieAnimationView animationView;
    static LottieAnimationView loseanimation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bomb = findViewById(R.id.bomb);
        win = findViewById(R.id.win);
        lose = findViewById(R.id.lose);
        animationView = findViewById(R.id.animation_view);
        loseanimation = findViewById(R.id.lose_animation);
        win.bringToFront() ;
        lose.bringToFront();
        animationView.bringToFront();
        loseanimation.bringToFront();
        GameEngine.getInstance().createGrid(MainActivity.this);
        bomb.setText(GameEngine.BOMB_NUMBER + "");
        animationView.setAnimation("confetti_blast.json");
        loseanimation.setAnimation("uh_oh.json");
    }

    public TextView getBomb(){
        return bomb;
    }

    public void onResetClicked(View v){
        GameEngine.getInstance().createGrid(MainActivity.this);
        bomb.setText(GameEngine.BOMB_NUMBER+"");
        MainActivity.win.setVisibility(View.INVISIBLE);
        MainActivity.lose.setVisibility(View.INVISIBLE);
        MainActivity.animationView.setVisibility(View.INVISIBLE);
        MainActivity.loseanimation.setVisibility(View.INVISIBLE);
    }


}
