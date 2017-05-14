package com.bwhitecr.fractal.tree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class FractalTreeView extends ImageView {

	private final FractalTree tree = new FractalTree();
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
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!isInEditMode()) {
            Bitmap b = getBitmap(canvas.getHeight(), canvas.getWidth());
            canvas.drawBitmap(b, 0, 0, null);
        }
    }

	public void setProperties(TreeProperties treeProperties) {
		tree.setTreeProperties(treeProperties);
        mBitmap = null;
		this.invalidate();
	}

    private Bitmap getBitmap(int height, int width) {
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(mBitmap);
            tree.drawFractalTree(c);
        }
        return mBitmap;
    }
}
