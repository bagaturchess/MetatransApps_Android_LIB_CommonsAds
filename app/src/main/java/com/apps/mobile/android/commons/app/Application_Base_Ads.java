package com.apps.mobile.android.commons.app;


import com.apps.mobile.android.commons.ads.api.IAdsConfigurations;
import com.apps.mobile.android.commons.ads.impl.AdsManager;
import com.apps.mobile.android.commons.model.GameData_Base;


public abstract class Application_Base_Ads extends Application_Base {

	
	private AdsManager adsmanager;
	
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
	}

	public abstract IAdsConfigurations getAdsConfigurations();


	public static Application_Base_Ads getInstance() {
		return (Application_Base_Ads) Application_Base.getInstance();
	}
	
	
	public void openInterstitial() {
		Object activity = getCurrentActivity();
		if (activity instanceof IActivityInterstitial) {
			((IActivityInterstitial)activity).openInterstitial();
		} else {
			if (isTestMode()) throw new IllegalStateException("Not in IActivityInterstitial");
		}
	}
	
	
	@Override
	public GameData_Base createGameDataObject() {
		throw new UnsupportedOperationException();
	}
	
	
	public AdsManager getAdsManager() {
		if (adsmanager == null) {
			adsmanager = AdsManager.getSingleton(this);
		}
		return adsmanager;
	}
}
