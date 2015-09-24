package com.bwhitecr.fractal.tree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class FractalTreeView extends ImageView {

	private FractalTree tree = new FractalTree();
    private Bitmap mBitmap;
	
	public FractalTreeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public FractalTreeView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public FractalTreeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

    @Override
    public Drawable getDrawable() {
        Bitmap b = getBitmap();
        return new BitmapDrawable(b);
    }
	
	public void setProperties(float branches, float bifurcations) {
		tree.setBranchCount(branches);
        mBitmap = null;
		this.invalidate();
	}

    private Bitmap getBitmap() {
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(mBitmap);
            tree.drawFractalTree(c);
        }
        return mBitmap;
    }
}
