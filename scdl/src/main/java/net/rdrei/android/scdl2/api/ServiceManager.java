package net.rdrei.android.scdl2.api;

import android.app.Application;

import com.google.inject.Inject;
import com.google.inject.Injector;

import net.rdrei.android.scdl2.ApplicationPreferences;
import net.rdrei.android.scdl2.api.service.DownloadService;
import net.rdrei.android.scdl2.api.service.PlaylistService;
import net.rdrei.android.scdl2.api.service.ResolveService;
import net.rdrei.android.scdl2.api.service.TrackService;

import roboguice.RoboGuice;
import roboguice.inject.ContextSingleton;

/**
 * Singleton managing creation of API services and setting them up with default parameters, in case
 * need to access APIs with authentication requirements.
 *
 * @author pascal
 */
@ContextSingleton
public class ServiceManager {
	private final Injector mInjector;

	@Inject
	private ApplicationPreferences mPreferences;

	@Inject
	public ServiceManager(final Application application) {
		mInjector = RoboGuice.getBaseApplicationInjector(application);
	}

	private void setupService(final SoundcloudApiService service) {
		service.setUseSSL(mPreferences.getSSLEnabled());
	}

	public TrackService trackService() {
		final TrackService service = mInjector.getInstance(TrackService.class);
		setupService(service);
		return service;
	}

	public ResolveService resolveService() {
		final ResolveService service = mInjector.getInstance(ResolveService.class);
		setupService(service);
		return service;
	}

	public DownloadService downloadService() {
		final DownloadService service = mInjector.getInstance(DownloadService.class);
		setupService(service);
		return service;
	}

	public PlaylistService playlistService() {
		final PlaylistService service = mInjector.getInstance(PlaylistService.class);
		setupService(service);
		return service;
	}
}
