package com.seanbot.gameoflife.menudialogs;

import com.seanbot.gameoflife.GameOfLifeView;
import com.seanbot.gameoflife.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * The menu item that handles the color of the cells to be created when a user
 * touches the screen.
 * 
 * @author Sean Clapp
 * 
 */
public class AdjustColorDialog extends Dialog {

	public AdjustColorDialog(Context context) {
		super(context);
		setContentView(R.layout.color_picker_layout);

		final int startingColor = GameOfLifeView.getInstanceOf()
				.getStartingTouchColor();

		SeekBar seekBarRedValue = (SeekBar) findViewById(R.id.seekBarRed);
		SeekBar seekBarBlueValue = (SeekBar) findViewById(R.id.seekBarBlue);
		SeekBar seekBarGreenValue = (SeekBar) findViewById(R.id.seekBarGreen);

		final EditText editTextRedValue = (EditText) findViewById(R.id.editTextRedValue);
		final EditText editTextBlueValue = (EditText) findViewById(R.id.editTextBlueValue);
		final EditText editTextGreenValue = (EditText) findViewById(R.id.editTextGreenValue);

		final ImageView imageViewColor = (ImageView) findViewById(R.id.imageViewColor);
		Button btnSelectColor = (Button) findViewById(R.id.buttonSelectColor);

		editTextRedValue.setText("" + ((startingColor >> 16) & 0xFF));
		editTextBlueValue.setText("" + (startingColor & 0xFF));
		editTextGreenValue.setText("" + ((startingColor >> 8) & 0xFF));
		seekBarRedValue.setMax(255);
		seekBarRedValue.setProgress(Integer.parseInt(editTextRedValue.getText()
				.toString()));
		seekBarBlueValue.setMax(255);
		seekBarBlueValue.setProgress(Integer.parseInt(editTextBlueValue
				.getText().toString()));
		seekBarGreenValue.setMax(255);
		seekBarGreenValue.setProgress(Integer.parseInt(editTextGreenValue
				.getText().toString()));

		imageViewColor.setBackgroundColor(GameOfLifeView.getInstanceOf()
				.getStartingTouchColor());

		OnSeekBarChangeListener seekBarListenerColorRed = new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				editTextRedValue.setText("" + progress);
				GameOfLifeView.getInstanceOf().setStartingTouchColor(
						Color.rgb(Integer.parseInt(editTextRedValue.getText()
								.toString()), Integer
								.parseInt(editTextGreenValue.getText()
										.toString()), Integer
								.parseInt(editTextBlueValue.getText()
										.toString())));
				imageViewColor.setBackgroundColor(GameOfLifeView
						.getInstanceOf().getStartingTouchColor());

			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

		};

		seekBarRedValue.setOnSeekBarChangeListener(seekBarListenerColorRed);

		OnSeekBarChangeListener seekBarListenerColorBlue = new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				editTextBlueValue.setText("" + progress);
				GameOfLifeView.getInstanceOf().setStartingTouchColor(
						Color.rgb(Integer.parseInt(editTextRedValue.getText()
								.toString()), Integer
								.parseInt(editTextGreenValue.getText()
										.toString()), Integer
								.parseInt(editTextBlueValue.getText()
										.toString())));
				imageViewColor.setBackgroundColor(GameOfLifeView
						.getInstanceOf().getStartingTouchColor());
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

		};

		seekBarBlueValue.setOnSeekBarChangeListener(seekBarListenerColorBlue);

		OnSeekBarChangeListener seekBarListenerColorGreen = new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				editTextGreenValue.setText("" + progress);
				GameOfLifeView.getInstanceOf().setStartingTouchColor(
						Color.rgb(Integer.parseInt(editTextRedValue.getText()
								.toString()), Integer
								.parseInt(editTextGreenValue.getText()
										.toString()), Integer
								.parseInt(editTextBlueValue.getText()
										.toString())));
				imageViewColor.setBackgroundColor(GameOfLifeView
						.getInstanceOf().getStartingTouchColor());
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

		};

		seekBarGreenValue.setOnSeekBarChangeListener(seekBarListenerColorGreen);

		btnSelectColor.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}

		});
	}

}
