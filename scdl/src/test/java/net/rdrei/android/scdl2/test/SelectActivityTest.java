package net.rdrei.android.scdl2.test;


import net.rdrei.android.scdl2.ui.SelectTrackActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class SelectActivityTest {

	@Test
	public void smokeTestOnCreate() {
		new SelectTrackActivity();
		// Can't inflate the layout, at the moment, because it can't extract the
		// admob_unit_id.
		// activity.onCreate(null);
	}
}