package com.seanbot.gameoflife.tools;

import java.util.Random;

import android.graphics.Color;

import com.seanbot.gameoflife.Cell;
import com.seanbot.gameoflife.CellList;
import com.seanbot.gameoflife.GameOfLifeView;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 *        This will be used to store the shapes that will be called For example,
 *        if you want to build a glider, you will call the buildGlider() method.
 *        In a future version, the user will be able to create their own shapes
 *        for use, these 2d arrays were for testing purposes/some of the random
 *        shapes.
 * 
 */
public class ShapeManager {

	private Random r = new Random();
	private int screenH;
	private int screenW;
	private int sizeOfCells;

	public int[][] glider1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 0 } };
	public int[][] glider2 = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 1, 0 } };
	public int[][] glider3 = { { 0, 0, 1 }, { 1, 0, 1 }, { 0, 1, 1 } };

	public int[][] glider4 = { { 0, 1, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };

	public int[][] ship = { { 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 1 } };

	public int[][] pulsar = { { 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0 }, };

	public int heart[][] = { { 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
			{ 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 } };

	public int gol[][] = {
			{ 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0,
					0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0,
					1, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0,
					0, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, };

	public ShapeManager() {
		// TODO Auto-generated constructor stub
		screenH = GameOfLifeView.getInstanceOf().getCellList().getHeight();
		screenW = GameOfLifeView.getInstanceOf().getCellList().getWidth();
		sizeOfCells = GameOfLifeView.getInstanceOf().getCellList().getSIZEMOD();
	}

	/**
	 * 
	 * Sets cells to be alive or dead based off a pre-built 2d array
	 * (shapeArray). This can be used to build any shape necessary if you have
	 * the appropriate 2d array.
	 * 
	 * @param shapeArray
	 *            the 2d array that will specify the object to be built. A "1"
	 *            represents a live cell and a "0" represents a dead cell
	 * @param touched_x
	 *            the touched x coordinate to be used in determining the shape's
	 *            position on the board
	 * @param touched_y
	 *            the touched y coordinate to be used in determining the shape's
	 *            position on the board
	 * @param startingTouchColor
	 *            desired starting color of the shape. Each cell will be *close*
	 *            to this color.
	 * 
	 */
	public void buildShape(int[][] shapeArray, float touched_x,
			float touched_y, int startingTouchColor) {
		int rows = shapeArray.length;
		int cols = shapeArray[0].length;
		Cell cc;
		float cellXpos, cellYpos, origCellXpos;

		/**
		 * Starts the cell at the top left position of the array. (The touched
		 * is still the center)
		 */

		// check to make sure the shape will fit on the board.
		if (touched_x > (sizeOfCells * (cols / 2) + sizeOfCells)
				&& touched_x < screenW
						- (sizeOfCells * (cols / 2) + sizeOfCells)
				&& touched_y > (sizeOfCells * (rows / 2) + sizeOfCells)
				&& touched_y < screenH
						- (sizeOfCells * (rows / 2) + sizeOfCells)) {

			// first cell matching 0/0 of the cell array
			cc = GameOfLifeView
					.getInstanceOf()
					.getCellList()
					.getCellByPos(
							touched_x
									- (sizeOfCells * (cols / 2) + sizeOfCells),
							touched_y
									- (sizeOfCells * (rows / 2) + sizeOfCells));
			origCellXpos = cc.getxPos();
			cellXpos = cc.getxPos();
			cellYpos = cc.getyPos();

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					cc = GameOfLifeView.getInstanceOf().getCellList()
							.getCellByPos(cellXpos, cellYpos);
					cellXpos += sizeOfCells;
					if (shapeArray[i][j] == 1) {
						cc.setIsAlive(1);
						cc.setCellColor(startingTouchColor + 40 - r.nextInt(80));
					}

				}
				// restart the cellxpos
				cellXpos = origCellXpos;
				cellYpos += sizeOfCells;
			}
		}
	}

	/**
	 * Has a chance to build a random shape. If it does build a random shape,
	 * this returns true, if not, it returns false.
	 */
	public boolean buildRandomShapes() {
		Random r = new Random();

		if (r.nextInt(1500) == 1342) {
			for (int i = 0; i < 3; i++) {
				buildShape(pulsar, r.nextInt(screenW - 50),
						r.nextInt(screenH - 50), getRandomColor());
				return true;
			}
		}
		if (r.nextInt(300) == 12) {
			buildShape(ship, r.nextInt(screenW - 50), r.nextInt(screenH - 50),
					getRandomColor());
			return true;
		}
		if (r.nextInt(142) == 3) {
			buildShape(glider1, r.nextInt(screenW - 50),
					r.nextInt(screenH - 50), getRandomColor());
			return true;
		}
		if (r.nextInt(142) == 4) {
			buildShape(glider2, r.nextInt(screenW - 50),
					r.nextInt(screenH - 50), getRandomColor());
			return true;
		}
		if (r.nextInt(142) == 5) {
			buildShape(glider3, r.nextInt(screenW - 50),
					r.nextInt(screenH - 50), getRandomColor());
			return true;
		}
		if (r.nextInt(142) == 6) {
			buildShape(glider4, r.nextInt(screenW - 50),
					r.nextInt(screenH - 50), getRandomColor());
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return Returns a random color to be built with the buildRandomShapes()
	 *         method.
	 */
	private int getRandomColor() {
		Random r = new Random();
		return Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}
}
