// IRemoteService.aidl
package com.atooma.plugin;

import com.atooma.plugin.Values;
import com.atooma.plugin.ParameterBundle;
import com.atooma.plugin.Schedule;
import com.atooma.sdk.IAtoomaService;

interface IAlarmBasedTriggerPlugin {
	boolean isVisible();
	String getId();
	List<Values> getParameters();
	List<Values> getVariables();
	int getTitleResource();
	int getIconResourceNormal();
	List getParameterLabelIfNullResources();
	List getParameterTitleResources();
	List getVariableTitleResources();
	void timeout(in IAtoomaService atoomaService, String ruleId, in ParameterBundle parameters);
	void revoke(String ruleId);
	int getVersion();
	Schedule getScheduleInfo();
}