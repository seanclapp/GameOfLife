package com.seanbot.gameoflife;

import android.graphics.Color;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        Cell holds an individual cell. These will be used to populate a
 *        CellList, and if you need to change any values of a cell, you change
 *        them using the gets/sets in this class.
 * 
 */
public class Cell {
	int isAlive;
	float xPos;
	float yPos;
	int cellRowNum;
	int cellColNum;
	int cellColor;
	int fadeOutNum;

	/**
	 * 
	 * @param alive
	 *            The alive status of the cell. 1=alive, 0=dead
	 * @param x
	 *            X position of the cell on the screen (Used for drawing
	 *            purposes).
	 * @param y
	 *            Y position of the cell on the screen (Used for drawing
	 *            purposes).
	 * @param rowNum
	 *            Row number of the cell.
	 * @param colNum
	 *            Column number of the cell.
	 * @param color
	 *            Color of the cell.
	 */
	public Cell(int alive, float x, float y, int rowNum, int colNum, int color) {
		isAlive = alive;
		cellColor = color;
		xPos = x;
		yPos = y;
		cellRowNum = rowNum;
		cellColNum = colNum;
	}

	/**
	 * Returns the live status of the cell. 1 = alive, 0 = dead
	 * 
	 * @return
	 */
	public int getIsAlive() {
		return isAlive;
	}

	/**
	 * Sets the live status of the cell
	 * 
	 * @param isAlive
	 *            1 or 0 will determine the live status of the cell. 1 = alive,
	 *            0 = dead
	 */
	public void setIsAlive(int isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * Gets the x position of the cell
	 * 
	 * @return
	 */
	public float getxPos() {
		return xPos;
	}

	/**
	 * Set the x center position of the cell (used for drawing/touch purposes)
	 * 
	 * @param xPos
	 *            x center position of the cell
	 */
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	/**
	 * Gets y center position of the cell (used for drawing/touch purposes)
	 * 
	 * @return
	 */
	public float getyPos() {
		return yPos;
	}

	/**
	 * Sets y center position of the cell (used for drawing/touch purposes)
	 * 
	 * @param yPos
	 *            y center position of the cell
	 */
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	/**
	 * Gets color of the cell
	 * 
	 * @return
	 */
	public int getCellColor() {
		return cellColor;
	}

	/**
	 * Sets color of the cell
	 * 
	 * @param cellColor
	 *            integer value of the cell color
	 */
	public void setCellColor(int cellColor) {
		this.cellColor = cellColor;
	}

	/**
	 * Fade out number will handle the appropriate value of the dying cell
	 * 
	 * @return
	 */
	public int getFadeOutNum() {
		return fadeOutNum;
	}

	/**
	 * Sets the fade out number that will handle the appropriate value of the
	 * dying cell
	 * 
	 * @param fadeOutNum
	 *            value from 5-1 that will determine the fade out phase of a
	 *            dying cell
	 */
	public void setFadeOutNum(int fadeOutNum) {
		this.fadeOutNum = fadeOutNum;
	}

	/**
	 * Returns the cell row number
	 * 
	 * @return
	 */
	public int getCellRowNum() {
		return cellRowNum;
	}

	/**
	 * Sets the cell row number
	 * 
	 * @param cellRowNum
	 *            value for the row number of the current cell
	 */
	public void setCellRowNum(int cellRowNum) {
		this.cellRowNum = cellRowNum;
	}

	/**
	 * Gets the cell column number
	 * 
	 * @return
	 */
	public int getCellColNum() {
		return cellColNum;
	}

	/**
	 * Sets the cell column number
	 * 
	 * @param cellColNum
	 *            value for the column number of the current cell
	 */
	public void setCellColNum(int cellColNum) {
		this.cellColNum = cellColNum;
	}

}
