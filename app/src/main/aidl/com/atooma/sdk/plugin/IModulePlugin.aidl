// IRemoteService.aidl
package com.atooma.sdk.plugin;

interface IModulePlugin {
		boolean init();
		String getId();
		int getVersion();
		boolean isVisible();
		void setCategory();
		int getTitleResource();
		int getIconResourceNormal();
		List<IBinder> getTriggers();
		List<IBinder> getAlarmTriggers();
		List<IBinder> getIntentTriggers();
		List<IBinder> getConditionCheckers();
		List<IBinder> getPerformers();
		String getPackage();
		boolean isAuthRequired();
		boolean isAuthenticated();
		String getAutenticatedText();
		void clearAutenticated();
}