package com.example.q.minesweeper.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.q.minesweeper.GameEngine;
import com.example.q.minesweeper.MainActivity;


public class Grid extends GridView {

    public Grid(Context context, AttributeSet attrs){
        super (context, attrs);
        Log.e("Grid","context문제?");
        GameEngine.getInstance().createGrid(context , MainActivity.BOMB, MainActivity.WIDTH, MainActivity.HEIGHT);
        Log.e("Grid","creategrid문제");
        setNumColumns(GameEngine.WIDTH);
        setAdapter(new GridAdapter());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return GameEngine.getInstance().WIDTH * GameEngine.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getCellAt(position);
        }
    }
}
