package com.seanbot.gameoflife;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.seanbot.gameoflife.tools.SoundManager;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        View to hold the animation/threads/touch events etc. This is the main
 *        view for the application and will be what the user interacts with the
 *        most.
 * 
 */
public class GameOfLifeView extends SurfaceView implements
		SurfaceHolder.Callback {
	/**
	 * Variable for singleton pattern, used for accessing this class throughout
	 * the program.
	 */
	private static GameOfLifeView golView;

	/**
	 * MAXPOINTS is the maximum allowed touch inputs.
	 */
	final int MAXPOINTS = 5;

	/**
	 * startingTouchColor is the color of the cell upon touch creation, this
	 * variable can be changed via menu dialog AdjustColorDialog. When the user
	 * requests a new color, this value is changed.
	 */
	volatile int startingTouchColor = Color.rgb(155, 155, 155);

	/**
	 * width/height of the current view
	 */
	private int screenWidth, screenHeight;

	/**
	 * Touch arrays for holding touch events.
	 */
	float[] xTouch = new float[MAXPOINTS];
	float[] yTouch = new float[MAXPOINTS];
	boolean[] isTouch = new boolean[MAXPOINTS];

	private ThreadDraw threadDraw;
	private ThreadGeneration threadGen;
	public SoundManager soundManager;
	private CellList cellList;

	/**
	 * Constructor for the view.
	 * 
	 * @param context
	 */
	public GameOfLifeView(Context context) {
		super(context);
		getHolder().addCallback(this);
		golView = this;
		soundManager = new SoundManager();
		cellList = new CellList();
		threadDraw = new ThreadDraw(getHolder(), this);
		threadGen = new ThreadGeneration(this);

		// get screen width and height
		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		screenWidth = metrics.widthPixels;
		screenHeight = metrics.heightPixels;
	}

	/**
	 * 
	 * @return Screen width of current view
	 */
	public int getScreenWidth() {
		return screenWidth;
	}

	/**
	 * 
	 * @return Screen height of current view.
	 */
	public int getScreenHeight() {
		return screenHeight;
	}

	/**
	 * 
	 * @return ThreadDraw object being used in this view.
	 */
	public ThreadDraw getThreadDraw() {
		return threadDraw;
	}

	/**
	 * 
	 * @return ThreadGeneration object being used in this view.
	 */
	public ThreadGeneration getThreadGen() {
		return threadGen;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	/**
	 * Create new instances of threads when this view is created and set the
	 * threads running/start them.
	 */
	public void surfaceCreated(SurfaceHolder holder) {

		if (threadDraw.getState() == Thread.State.TERMINATED) {
			threadDraw = new ThreadDraw(getHolder(), this);
		}
		threadDraw.setRunning(true);
		threadDraw.start();
		if (threadGen.getState() == Thread.State.TERMINATED) {
			threadGen = new ThreadGeneration(this);
		}
		threadGen.setRunning(true);
		threadGen.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		threadGen.setRunning(false);
		threadDraw.setRunning(false);
	}

	/**
	 * 
	 * @return returns the static instance of this object. Singleton pattern in
	 *         use to access the view from outside this class.
	 */
	public static synchronized GameOfLifeView getInstanceOf() {
		return golView;
	}

	/**
	 * Handles the touch events. When a touch event is registered, it marks the
	 * location and touch id for use in the ThreadGeneration class.
	 */
	public boolean onTouchEvent(MotionEvent event) {

		int pointerIndex = ((event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT);
		int pointerId = event.getPointerId(pointerIndex);
		int action = (event.getAction() & MotionEvent.ACTION_MASK);
		int pointCnt = event.getPointerCount();

		try {
			if (pointCnt <= MAXPOINTS) {
				if (pointerIndex <= MAXPOINTS - 1) {
					int id = 0;
					for (int i = 0; i < pointCnt; i++) {

						id = event.getPointerId(i);
						xTouch[id] = event.getX(i);
						yTouch[id] = event.getY(i);

					}

					switch (action) {
					case MotionEvent.ACTION_DOWN:

						try {
							isTouch[pointerId] = true;
						} catch (Exception e) {
							e.printStackTrace();
						}

						break;
					case MotionEvent.ACTION_POINTER_DOWN:
						isTouch[pointerId] = true;
						break;
					case MotionEvent.ACTION_MOVE:
						isTouch[pointerId] = true;
						break;
					case MotionEvent.ACTION_UP:
						isTouch[pointerId] = false;
						break;
					case MotionEvent.ACTION_POINTER_UP:
						isTouch[pointerId] = false;
						break;
					case MotionEvent.ACTION_CANCEL:
						isTouch[pointerId] = false;
						break;
					default:
						isTouch[pointerId] = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @return the color that will be assigned to newly created cells when the
	 *         user touches the screen
	 */
	public int getStartingTouchColor() {
		return startingTouchColor;
	}

	/**
	 * 
	 * @param startingTouchColor
	 *            The color you want to set as the startingTouchColor.
	 */
	public void setStartingTouchColor(int startingTouchColor) {
		this.startingTouchColor = startingTouchColor;
	}

	/**
	 * 
	 * @return SoundManager object used in this view to handle sound events.
	 */
	public SoundManager getSoundManager() {
		return soundManager;
	}

	/**
	 * 
	 * @return CellList object used in this view. (Houses the cell information)
	 */
	public CellList getCellList() {
		return cellList;
	}
}
