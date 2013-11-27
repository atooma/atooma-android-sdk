// IRemoteService.aidl
package com.atooma.plugin;

interface IModulePlugin {
		boolean init();
		String getId();
		int getVersion();
		boolean isVisible();
		void setCategory();
		int getTitleResource();
		int getIconResourceNormal();
		int getIconResourcePressed();
		List<IBinder> getTriggers();
		List<IBinder> getAlarmTriggers();
		List<IBinder> getIntentTriggers();
		List<IBinder> getConditionCheckers();
		List<IBinder> getPerformers();
		String getPackage();
}