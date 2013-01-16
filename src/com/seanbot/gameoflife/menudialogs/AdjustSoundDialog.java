package com.seanbot.gameoflife.menudialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.seanbot.gameoflife.GameOfLifeView;
import com.seanbot.gameoflife.R;

/**
 * The menu item dialog that handles turning the sound on/off.
 * 
 * @author Sean Clapp
 * 
 */
public class AdjustSoundDialog extends Dialog {

	public AdjustSoundDialog(Context context) {
		super(context);
		setContentView(R.layout.sound_adjust_layout);

		ToggleButton toggleBtnSounds = (ToggleButton) findViewById(R.id.toggleButtonSounds);

		toggleBtnSounds.setChecked(GameOfLifeView.getInstanceOf()
				.getSoundManager().isSoundsEnabled());

		toggleBtnSounds
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							GameOfLifeView.getInstanceOf().getSoundManager()
									.setSoundsEnabled(true);
						} else {
							GameOfLifeView.getInstanceOf().getSoundManager()
									.setSoundsEnabled(false);
						}
					}
				});
	}
}
