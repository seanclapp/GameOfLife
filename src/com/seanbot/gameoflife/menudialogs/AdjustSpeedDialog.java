package com.seanbot.gameoflife.menudialogs;

import com.seanbot.gameoflife.GameOfLifeView;
import com.seanbot.gameoflife.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * The menu item dialog that handles adjusting the speed of the generations.
 * (The delay in between each generation)
 * 
 * @author Sean Clapp
 * 
 */
public class AdjustSpeedDialog extends Dialog {

	public AdjustSpeedDialog(Context context) {
		super(context);
		setContentView(R.layout.speed_dialog_layout);

		final int startingCellSpeed = GameOfLifeView.getInstanceOf()
				.getThreadGen().getSpeed();

		SeekBar seekBarSpeedOfCells = (SeekBar) findViewById(R.id.seekBarSpeedOfCells);
		final TextView textViewSpeed = (TextView) findViewById(R.id.textViewSpeed);
		Button doneSpeedOfCells = (Button) findViewById(R.id.buttonSpeedDone);
		Button cancelSpeedOfCells = (Button) findViewById(R.id.buttonSpeedCancel);

		seekBarSpeedOfCells.setMax(200);
		seekBarSpeedOfCells.setProgress(startingCellSpeed);
		textViewSpeed.setText("" + startingCellSpeed);

		OnSeekBarChangeListener speedSeekBarListener = new OnSeekBarChangeListener() {
			public void onStopTrackingTouch(SeekBar seekBar) {
				textViewSpeed.setText("" + seekBar.getProgress());
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				textViewSpeed.setText("" + seekBar.getProgress());
			}

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				textViewSpeed.setText("" + seekBar.getProgress());
				GameOfLifeView.getInstanceOf().getThreadGen()
						.setSpeed(seekBar.getProgress());
			}
		};

		seekBarSpeedOfCells.setOnSeekBarChangeListener(speedSeekBarListener);

		doneSpeedOfCells.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}

		});

		cancelSpeedOfCells.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				GameOfLifeView.getInstanceOf().getThreadGen()
						.setSpeed(startingCellSpeed);
				dismiss();
			}

		});

	}

}
