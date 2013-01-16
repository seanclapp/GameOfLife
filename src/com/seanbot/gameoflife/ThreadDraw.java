package com.seanbot.gameoflife;

import com.seanbot.gameoflife.tools.DrawManager;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        This thread handles drawing the cells on the board.
 * 
 */
public class ThreadDraw extends Thread {

	/**
	 * DRAWSPEED - The delay between draw events (in milliseconds)
	 */
	private final int DRAWSPEED = 50;
	/**
	 * isRunning - boolean value to check if the thread is running, this should
	 * be set to true before starting the thread.
	 */
	private boolean isRunning;
	private DrawManager drawMgr;
	private SurfaceHolder sh;

	/**
	 * Constructor class for ThreadDraw
	 * 
	 * @param holder
	 *            surface holder for the thread
	 * @param view
	 */
	public ThreadDraw(SurfaceHolder holder, GameOfLifeView view) {
		sh = holder;
		drawMgr = new DrawManager();
	}

	/**
	 * Sets the running status of the thread
	 * 
	 * @param run
	 */
	public void setRunning(boolean run) {
		isRunning = run;
	}

	public DrawManager getDrawMgr() {
		return drawMgr;
	}

	public void run() {
		while (isRunning) {
			if (sh.getSurface().isValid()) {
				Canvas canvas = sh.lockCanvas();
				try {
					canvas.drawColor(Color.BLACK);

					drawMgr.drawCells(GameOfLifeView.getInstanceOf()
							.getCellList(), canvas);
					sh.unlockCanvasAndPost(canvas);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				try {
					sleep(DRAWSPEED);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isRunning() {
		return isRunning;
	}
}
