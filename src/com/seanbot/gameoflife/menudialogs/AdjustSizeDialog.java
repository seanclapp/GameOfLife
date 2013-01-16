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
 * The menu item dialog that handles adjusting the size of the cells drawn.
 * 
 * @author Sean Clapp
 * 
 */
public class AdjustSizeDialog extends Dialog {

	public AdjustSizeDialog(Context context) {
		super(context);
		setContentView(R.layout.size_dialog_layout);

		final int startingCellSize = GameOfLifeView.getInstanceOf()
				.getThreadDraw().getDrawMgr().getCellModifier();

		SeekBar seekBarSizeOfCells = (SeekBar) findViewById(R.id.seekBarSizeOfCells);
		final TextView textViewSize = (TextView) findViewById(R.id.textViewSize);
		Button doneSizeOfCells = (Button) findViewById(R.id.buttonDoneSizeOfCells);
		Button cancelSizeOfCells = (Button) findViewById(R.id.buttonCancelSizeOfCells);

		seekBarSizeOfCells.setMax(10);
		seekBarSizeOfCells.setProgress(GameOfLifeView.getInstanceOf()
				.getThreadDraw().getDrawMgr().getCellModifier());
		textViewSize.setText("" + startingCellSize);

		OnSeekBarChangeListener sizeSeekBarListener = new OnSeekBarChangeListener() {
			public void onStopTrackingTouch(SeekBar seekBar) {
				// textViewSize.setText("" + seekBar.getProgress());
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// textViewSize.setText("" + seekBar.getProgress());
			}

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				textViewSize.setText("" + seekBar.getProgress());
				GameOfLifeView.getInstanceOf().getThreadDraw().getDrawMgr()
						.setCellModifier(seekBar.getProgress());
			}
		};

		seekBarSizeOfCells.setOnSeekBarChangeListener(sizeSeekBarListener);

		doneSizeOfCells.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}

		});

		cancelSizeOfCells.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				GameOfLifeView.getInstanceOf().getThreadDraw().getDrawMgr()
						.setCellModifier(startingCellSize);
				dismiss();
			}

		});

	}

}
