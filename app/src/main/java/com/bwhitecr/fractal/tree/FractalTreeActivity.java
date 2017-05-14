package com.bwhitecr.fractal.tree;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.widget.SeekBar;

import com.bwhitecr.fractal.tree.databinding.MainActivityBinding;

public class FractalTreeActivity extends Activity {
	private FractalTreeView treeView;
    private final TreeProperties treeProperties = new TreeProperties(40, 2);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setTreeProperties(treeProperties);
        binding.setHandlers(this);

        treeView = (FractalTreeView)findViewById(R.id.fractalTreeView1);


        Button button = (Button)findViewById(R.id.buttonRedraw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treeView.setProperties(treeProperties);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fractal_tree, menu);
        return true;
    }

    public void onClickRedraw(View v) {
        treeView.setProperties(treeProperties);
    }

    public void onChangeBifurcations(SeekBar seekBar, int progressValue, boolean fromUser) {
        treeProperties.setBifurcations(progressValue);
    }

    public void onChangeBranches(SeekBar seekBar, int progressValue, boolean fromUser) {
        treeProperties.setBranches(progressValue);
    }
}
