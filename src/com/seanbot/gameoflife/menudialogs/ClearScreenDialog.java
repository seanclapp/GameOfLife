package com.seanbot.gameoflife.menudialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.seanbot.gameoflife.GameOfLifeView;
import com.seanbot.gameoflife.R;

/**
 * The menu item dialog that handles clearin the screen.
 * 
 * @author Sean Clapp
 * 
 */
public class ClearScreenDialog extends Dialog {
	int speed;

	public ClearScreenDialog(Context context) {
		super(context);
		setContentView(R.layout.clear_screen_layout);
		Button btnClearScreenNo = (Button) findViewById(R.id.buttonClearScreenNo);
		Button btnClearScreenYes = (Button) findViewById(R.id.buttonClearScreenYes);
		//
		speed = GameOfLifeView.getInstanceOf().getThreadGen().getSpeed();
		GameOfLifeView.getInstanceOf().getThreadGen().setSpeed(1000);

		btnClearScreenNo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				GameOfLifeView.getInstanceOf().getThreadGen().setSpeed(speed);
				dismiss();
			}
		});

		btnClearScreenYes.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				GameOfLifeView
						.getInstanceOf()
						.getCellList()
						.getCm()
						.killAllCells(
								GameOfLifeView.getInstanceOf().getCellList());
				GameOfLifeView.getInstanceOf().getThreadGen().setSpeed(speed);

				dismiss();
			}
		});

		this.setOnCancelListener(new DialogInterface.OnCancelListener() {

			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				GameOfLifeView.getInstanceOf().getThreadGen().setSpeed(speed);
			}
		});
	}
}
