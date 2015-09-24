package com.bwhitecr.fractal.tree;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.widget.SeekBar;

public class FractalTreeActivity extends Activity {
	FractalTreeView treeView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractal_tree);

        treeView = (FractalTreeView)findViewById(R.id.fractalTreeView1);
        final SeekBar branchesSeekBar = (SeekBar)findViewById(R.id.seekBar1);
        final SeekBar bifurcationsSeekBar = (SeekBar)findViewById(R.id.seekBar2);


        Button button = (Button)findViewById(R.id.buttonRedraw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treeView.setProperties(branchesSeekBar.getProgress(), bifurcationsSeekBar.getProgress());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fractal_tree, menu);
        return true;
    }
}
