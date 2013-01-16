package com.seanbot.gameoflife;

import java.util.ArrayList;

import com.seanbot.gameoflife.tools.CellManager;

import android.util.DisplayMetrics;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        CellList will hold all of the cells in a manageable ArrayList.
 * 
 */
public class CellList {

	/*
	 * SIZEMOD - This is the size of the cells in pixels. More specifically, the
	 * size the cells should take up. If you change this variable, you will get
	 * more or less cells on screen. 
	 * 
	 * I wouldn't get much smaller than 10px per cell, because the program can
	 * get bogged down when the number of cells on screen reaches too high of a
	 * number.
	 * 
	 * This is different from the cellModifier found in DrawManager.java.
	 * cellModifier is used for drawing the cells, and the bounds can extend
	 * past the SIZEMOD bounds of the cell.
	 */
	private final int SIZEMOD = 10;

	// private CellList cellList;
	private ArrayList<Cell> arrayListOfCells;

	private CellManager cellManager;
	private int rows, columns, width, height;

	public CellList() {
		DisplayMetrics metrics = GameOfLifeView.getInstanceOf().getContext()
				.getResources().getDisplayMetrics();
		width = metrics.widthPixels;
		height = metrics.heightPixels;
		columns = width / SIZEMOD + 1;
		rows = height / SIZEMOD + 5;
		// cellList = this;
		arrayListOfCells = new ArrayList<Cell>();
		cellManager = new CellManager();
		cellManager.populateCellList(this);
	}

	/**
	 * Returns the CellManager that the cell list is currently using
	 * 
	 * @return
	 */
	public CellManager getCm() {
		return cellManager;
	}

	/**
	 * Returns the SIZEMOD the cell list is using
	 * 
	 * @return
	 */
	public int getSIZEMOD() {
		return SIZEMOD;
	}

	/**
	 * Returns the number of rows the cell list has
	 * 
	 * @return
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Returns the number of columns the cell list has
	 * 
	 * @return
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Returns the width of the view
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the heigh of the view
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Array List that holds the cells
	 * 
	 * @return
	 */
	public ArrayList<Cell> getArrayListOfCells() {
		return arrayListOfCells;
	}

	// /**
	// * this will return the current cell list (if needed to use in another
	// * class)
	// *
	// * @return
	// */
	// public static CellList getInstanceOf() {
	// return cellList;
	// }

	/**
	 * Returns a cell at a specified row and column
	 * 
	 * @param row
	 *            row value for the desired cell
	 * @param col
	 *            columne value for the desired cell
	 * @return
	 */
	public Cell getCellAt(int row, int col) {
		return this.getArrayListOfCells().get(row * this.getColumns() + col);
	}

	/**
	 * Returns a cell at a specified position
	 * 
	 * @param x
	 *            x center position of the desired cell
	 * @param y
	 *            y center position of the desired cell
	 * @return
	 */
	public Cell getCellByPos(float x, float y) {
		Cell c;
		for (int i = 0; i < arrayListOfCells.size(); i++) {
			c = arrayListOfCells.get(i);
			if (x <= c.getxPos() + SIZEMOD && x >= c.getxPos() - SIZEMOD
					&& y <= c.getyPos() + SIZEMOD && y >= c.getyPos() - SIZEMOD) {
				return c;
			}
		}
		return null;
	}

}
