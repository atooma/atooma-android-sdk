// IRemoteService.aidl
package com.atooma.plugin;

import com.atooma.plugin.Values;
import com.atooma.plugin.ParameterBundle;
import com.atooma.plugin.Schedule;

interface IAlarmBasedTriggerPlugin {
	boolean isVisible();
	String getId();
	List<Values> getParameters();
	List<Values> getVariables();
	int getTitleResource();
	int getIconResourceNormal();
	int getIconResourcePressed();
	List getParameterLabelIfNullResources();
	List getParameterTitleResources();
	List getVariableTitleResources();
	void timeout(String ruleId, in ParameterBundle parameters);
	int getVersion();
	Schedule getScheduleInfo();
}