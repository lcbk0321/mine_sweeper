package com.example.q.minesweeper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.q.minesweeper.util.Generator;
import com.example.q.minesweeper.util.PrintGrid;
import com.example.q.minesweeper.views.grid.Cell;

public class GameEngine {
    private static GameEngine instance;

    public static int BOMB_NUMBER = 20;
    public static int WIDTH = 13;
    public static int HEIGHT = 13;

    private Context context;

    private Cell[][] MinesweeperGrid=new Cell[WIDTH][HEIGHT];

    public static GameEngine getInstance(){
        if (instance == null){
            instance = new GameEngine();
        }
        return instance;
    }

    private GameEngine(){}

    public void createGrid(Context context){
        Log.e("GameEngine", "createGrid is working");
        this.context=context;
        //create grid and store it
        int[][] GeneratedGrid = Generator.generate(BOMB_NUMBER, WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid, WIDTH, HEIGHT);
        setGrid(context, GeneratedGrid);
    }

    private void setGrid ( final Context context, final int[][] grid){
        Log.e("setgrid",WIDTH+"w"+HEIGHT+"h");
        for ( int x = 0; x<WIDTH; x++){
            for(int y=0; y<HEIGHT; y++){
                Log.e("setgrid",x+"x"+y+"y");
                if ( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context , y * WIDTH + x);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }

    }
    public Cell getCellAt(int position) {
        int x = position % WIDTH;
        int y = position/WIDTH;
        return MinesweeperGrid[x][y];
    }

    public Cell getCellAt(int x, int y){
        return MinesweeperGrid[x][y];
    }

    public void click ( int x, int y){
        if ( x>=0 && y>=0 && x<WIDTH && y<HEIGHT && !getCellAt(x,y).isClicked() ){
            getCellAt(x,y).setClicked();

            if( getCellAt(x,y).getValue()==0){
                for ( int xt=-1; xt<=1; xt++){
                    for( int yt =-1; yt<=1; yt++){
                        if(xt != yt){
                            click(x+xt, y+yt);
                        }
                    }
                }
            }
        }
    }

    public boolean checkEnd(){
        int bombNotFound=BOMB_NUMBER;
        int notRevealed = WIDTH * HEIGHT ;
        for ( int x = 0; x < WIDTH; x++){
            for ( int y =0 ; y<HEIGHT ; y++){
                if( getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged() ){
                    notRevealed--;
                }
                if(getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb()){
                    bombNotFound--;
                }
            }
        }
        if( bombNotFound ==0 ){
            MainActivity.win.setVisibility(View.VISIBLE);
        }
        MainActivity.bomb.setText(bombNotFound + "");
        return false;
    }

    public void flag( int x , int y ){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        getCellAt(x,y).setFlagged(!isFlagged);
        getCellAt(x,y).invalidate();
        checkEnd();
    }

    public void onGameLost(){
        //handle lost game
        MainActivity.lose.setVisibility(View.VISIBLE);
        for ( int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                getCellAt(x, y).setRevealed();
            }
        }
    }


}
