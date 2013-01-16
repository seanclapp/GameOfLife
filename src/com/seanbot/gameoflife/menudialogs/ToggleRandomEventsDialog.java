package com.seanbot.gameoflife.menudialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.seanbot.gameoflife.GameOfLifeView;
import com.seanbot.gameoflife.R;

/**
 * The menu item dialog that handles turning random events on/off.
 * 
 * @author Sean Clapp
 * 
 */
public class ToggleRandomEventsDialog extends Dialog {

	public ToggleRandomEventsDialog(Context context) {
		super(context);
		setContentView(R.layout.toggle_random_event_layout);

		ToggleButton toggleBtnRandomEvents = (ToggleButton) findViewById(R.id.toggleButtonRandomEvents);

		toggleBtnRandomEvents.setChecked(GameOfLifeView.getInstanceOf()
				.getThreadGen().isRandomShapesEnabled());

		toggleBtnRandomEvents
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							GameOfLifeView.getInstanceOf().getThreadGen()
									.setRandomShapesEnabled(true);
						} else {
							GameOfLifeView.getInstanceOf().getThreadGen()
									.setRandomShapesEnabled(false);
						}
					}
				});
	}
}
