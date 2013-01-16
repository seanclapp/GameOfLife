package com.seanbot.gameoflife.tools;

import com.seanbot.gameoflife.Cell;
import com.seanbot.gameoflife.CellList;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        This handles all the drawing on screen.
 * 
 */
public class DrawManager {

	/**
	 * cellModifier is 1/2 the width of a cell. So a value of 4 would create
	 * cells that are 8 pixels wide. This variable is changed when the user
	 * adjusts the size.
	 * 
	 */
	private int cellModifier = 4;

	public DrawManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return cellModifier value that the DrawManager is currently set to.
	 */
	public int getCellModifier() {
		return cellModifier;
	}

	/**
	 * 
	 * @param cellModifier
	 *            Set the cellModifier variable to a certain number. Keep it
	 *            positive, and too large (20+) is probably unnecessary.
	 */
	public void setCellModifier(int cellModifier) {
		this.cellModifier = cellModifier;
	}

	/**
	 * 
	 * @param cl
	 *            The cell list that contains the cells you want to draw to the
	 *            screen.
	 * @param canvas
	 *            The canvas you want to use for drawing.
	 */
	public void drawCells(CellList cl, Canvas canvas) {
		Paint paint = new Paint();
		for (int n = 0; n < cl.getColumns() * cl.getRows(); n++) {
			Cell c = cl.getArrayListOfCells().get(n);
			if (c.getIsAlive() == 1) {
				paint.setColor(c.getCellColor());
				RectF rect = new RectF(c.getxPos() - cellModifier, c.getyPos()
						- cellModifier, c.getxPos() + cellModifier, c.getyPos()
						+ cellModifier);
				canvas.drawRoundRect(rect, 2, 2, paint);
			}

			if (c.getIsAlive() == 0 && c.getFadeOutNum() > 1) {
				paint.setColor(c.getCellColor());
				RectF rect = new RectF(c.getxPos() - cellModifier, c.getyPos()
						- cellModifier, c.getxPos() + cellModifier, c.getyPos()
						+ cellModifier);
				canvas.drawRoundRect(rect, 2, 2, paint);
			}
		}
	}
}
