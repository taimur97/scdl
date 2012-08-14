package net.rdrei.android.scdl.ui;

import net.rdrei.android.scdl.PreferenceManagerWrapper;
import net.rdrei.android.scdl.PreferenceManagerWrapperFactory;
import net.rdrei.android.scdl.R;
import roboguice.activity.RoboPreferenceActivity;
import android.os.Bundle;

import com.google.inject.Inject;

/**
 * The activity replacing {@link DownloadPreferencesFragment} on pre-ICS.
 * 
 * @author pascal
 * 
 */
public class DownloadPreferencesActivity extends RoboPreferenceActivity {
	@Inject
	private DownloadPreferencesDelegateFactory mDelegateFactory;
	private DownloadPreferencesDelegate mDelegate;

	@Inject
	private PreferenceManagerWrapperFactory mPreferenceManagerFactory;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PreferenceManagerWrapper preferenceManagerWrapper = mPreferenceManagerFactory
				.create(getPreferenceManager());
		mDelegate = mDelegateFactory.create(preferenceManagerWrapper);

		addPreferencesFromResource(R.xml.download_preferences);
		mDelegate.onCreate();
	}

	@Override
	public void onPause() {
		super.onPause();

		mDelegate.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();

		mDelegate.onResume();
	}

}
