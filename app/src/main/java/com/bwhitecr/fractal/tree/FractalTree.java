package com.bwhitecr.fractal.tree;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class FractalTree {

	private Canvas mCanvas;
	private float mAngle = 35f;
	private float mBranchScale = 0.75f;
	private float mMinBranches = 10;
	private final Paint mPaint;
	private float mBranches = 75;
	private int mBifurcations = 4;
	
	public FractalTree() {
		mPaint = new Paint();
	}
	
	private void drawBranch(float branch, float direction) {
		mCanvas.save();
		try {
			mCanvas.rotate(mAngle * direction);
			if (branch < 11)
				mPaint.setColor(Color.GREEN);
			else
				mPaint.setColor(0xFF6F6F00);
			mCanvas.drawLine(-branch/20f, 0, branch/20f, -branch*2, mPaint);
			if (branch > mMinBranches) {
				mCanvas.translate(0, -branch*2);
				
				float v = (mAngle / ((float)(mBifurcations /2))) / mAngle;
				float angle = -1;
				
				while (angle <= 1) {
					this.drawBranch(branch * mBranchScale, angle);
					angle += v;
				}
			}
		}
		finally {
			mCanvas.restore();
		}
	}
	
	public void drawFractalTree(Canvas canvas) {
		canvas.drawARGB(255, 0, 0, 0);
		mCanvas = canvas;
		mCanvas.translate(mCanvas.getWidth() / 2, mCanvas.getHeight());
		drawBranch(mBranches, 0);
	}
	
	public float getAngle() {
		return mAngle;
	}
	
	public void setAngle(float value) {
		mAngle = value;
	}
	
	public float getBranchScale() {
		return mBranchScale;
	}
	
	public void setBranchScale(float value) {
		mBranchScale = value;
	}
	
	public float getBranchCount() {
		return mBranches;
	}
	
	public void setBranchCount(float value) {
		this.mBranches = value;
	}
	
	public float getMinBranchCount() {
		return mMinBranches;
	}
	
	public void setMinBranchCount(float value) {
		mMinBranches = value;
	}
	
	public int getBifurcations() {
		return mBifurcations;
	}
	
	public void setBifurcations(int value) {
		mBifurcations = value;
	}

	public void setTreeProperties(TreeProperties treeProperties) {
		mBranches = treeProperties.getBranches();
		mBifurcations = treeProperties.getBifurcations();
	}
}
