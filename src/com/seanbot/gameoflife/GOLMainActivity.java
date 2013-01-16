package com.seanbot.gameoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.seanbot.gameoflife.menudialogs.AdjustColorDialog;
import com.seanbot.gameoflife.menudialogs.AdjustSizeDialog;
import com.seanbot.gameoflife.menudialogs.AdjustSoundDialog;
import com.seanbot.gameoflife.menudialogs.AdjustSpeedDialog;
import com.seanbot.gameoflife.menudialogs.ClearScreenDialog;
import com.seanbot.gameoflife.menudialogs.ToggleRandomEventsDialog;

/**
 * 
 * @author Sean Clapp
 * @email seanclapp@gmail.com
 * 
 */
public class GOLMainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GameOfLifeView golv = new GameOfLifeView(this);
		setContentView(golv);
		GameOfLifeView.getInstanceOf().getThreadDraw().start();
		GameOfLifeView.getInstanceOf().getThreadGen().start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.golmain_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {

		/**
		 * This will toggle the random events that occur.
		 */
		case R.id.toggle_random_events:
			ToggleRandomEventsDialog toggleRandomEventDialog = new ToggleRandomEventsDialog(
					this);
			toggleRandomEventDialog.show();
			return true;

			/**
			 * This will allow the user to select a color for the cells using a
			 * color wheel type interface. **not implemented**
			 */
		case R.id.adjust_color:
			// call adjust color wheel dialog here
			AdjustColorDialog adjustColorDialog = new AdjustColorDialog(this);
			adjustColorDialog.show();
			return true;

			/**
			 * adjust_size will allow the user to adjust the size of the cells
			 * using a seek bar. Not implemented with seek bar yet. User can
			 * increase or decrease cells 1 at a time.
			 */
		case R.id.adjust_size:
			// call adjust size dialog here
			AdjustSizeDialog adjustSizeDialog = new AdjustSizeDialog(this);
			adjustSizeDialog.show();
			return true;

			/**
			 * adjust_speed allows the user to adjust the speed of the
			 * generations. The slider is the value for the delay in
			 * milliseconds that the thread used to delay the generations.
			 */
		case R.id.adjust_speed:

			AdjustSpeedDialog adjustSpeedDialog = new AdjustSpeedDialog(this);
			adjustSpeedDialog.show();
			return true;

			/**
			 * adjust_sounds allows the user to turn the sound on/off.
			 */
		case R.id.adjust_sounds:
			AdjustSoundDialog adjustSoundDialog = new AdjustSoundDialog(this);
			adjustSoundDialog.show();
			return true;

			/**
			 * Clears the screen by killing all the living cells.
			 */
		case R.id.clear_screen:
			ClearScreenDialog clearScreenDialog = new ClearScreenDialog(this);
			clearScreenDialog.show();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

//	public void onBackPressed() {
//		Intent intent = new Intent(Intent.ACTION_MAIN);
//		intent.addCategory(Intent.CATEGORY_HOME);
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		startActivity(intent);
//	}
}
