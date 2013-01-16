package com.seanbot.gameoflife;

import java.util.Random;

import com.seanbot.gameoflife.tools.ShapeManager;

import android.content.Context;
import android.graphics.Color;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        This thread handles the generation running and building shapes on
 *        touch. Some testing was done with separating the generation and touch
 *        actions into separate threads, but the program would have to lock when
 *        the user touches the screen. Instead of locking, I decided to
 *        implement the touches on a delay, allowing the generations to run at a
 *        constant speed, and force the user to conform to the delay in
 *        registering touches. (I think this is more suited for the application)
 */
public class ThreadGeneration extends Thread {
	/**
	 * isRunning - boolean value to check if the thread is running, this should
	 * be set to true before starting the thread.
	 */
	private boolean isRunning;
	/**
	 * randomSHapesEnabled - Set this to true to have random shapes appear on
	 * the screen while the program is running.
	 */
	private boolean randomShapesEnabled;

	private GameOfLifeView golView;
	private ShapeManager shapeMgr;

	/**
	 * speed - Delay in milliseconds between each generation. A lower number
	 * will increase the speed of the generations.
	 */
	private int speed;

	public ThreadGeneration(GameOfLifeView view) {
		golView = view;
		shapeMgr = new ShapeManager();
		speed = 80;
	}

	public void run() {
		while (isRunning) {

			if (randomShapesEnabled) {
				if (shapeMgr.buildRandomShapes()) {
					golView.soundManager.playRandomSound();
					golView.soundManager.playRandomSound();
				}
			}

			if (golView.isTouch[0]) {
				shapeMgr.buildShape(shapeMgr.glider3, golView.xTouch[0],
						golView.yTouch[0], golView.startingTouchColor);
				golView.soundManager.playRandomSound();
			}

			if (golView.isTouch[1]) {
				shapeMgr.buildShape(shapeMgr.glider3, golView.xTouch[1],
						golView.yTouch[1], golView.startingTouchColor);
				golView.soundManager.playRandomSound();
			}

			if (golView.isTouch[2]) {
				shapeMgr.buildShape(shapeMgr.glider3, golView.xTouch[2],
						golView.yTouch[2], golView.startingTouchColor);
			}

			if (golView.isTouch[3]) {
				shapeMgr.buildShape(shapeMgr.glider3, golView.xTouch[3],
						golView.yTouch[3], golView.startingTouchColor);
			}

			if (golView.isTouch[4]) {
				shapeMgr.buildShape(shapeMgr.glider3, golView.xTouch[4],
						golView.yTouch[4], golView.startingTouchColor);
			}

			golView.getCellList()
					.getCm()
					.runGeneration(GameOfLifeView.getInstanceOf().getCellList());

			try {
				sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return Return current speed(delay in milliseconds)
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @param speed
	 *            New speed you want to set the speed variable to
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 
	 * @return Returns current state of the isRunning variable
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * 
	 * @param run
	 *            New value for the isRunning variable. true - thread should be
	 *            running, false - thread should not be running
	 */
	public void setRunning(boolean run) {
		isRunning = run;
	}

	/**
	 * 
	 * @param randomShapesEnabled
	 *            Sets the program to create random shapes on touch.
	 */
	public void setRandomShapesEnabled(boolean randomShapesEnabled) {
		this.randomShapesEnabled = randomShapesEnabled;
	}

	/**
	 * 
	 * @return Returns true if the thread is creating random shapes, false if
	 *         random shape creation is disabled
	 */
	public boolean isRandomShapesEnabled() {
		return randomShapesEnabled;
	}
}
