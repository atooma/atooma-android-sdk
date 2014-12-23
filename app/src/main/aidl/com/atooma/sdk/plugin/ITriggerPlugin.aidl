// IRemoteService.aidl
package com.atooma.sdk.plugin;

import com.atooma.sdk.plugin.Values;
import com.atooma.sdk.plugin.ParameterBundle;

interface ITriggerPlugin {
	boolean isVisible();
	String getId();
	List<Values> getParameters();
	List<Values> getVariables();
	int getTitleResource();
	int getIconResourceNormal();
	List getParameterLabelIfNullResources();
	List getParameterTitleResources();
	List getVariableTitleResources();
	void invoke(String ruleId, in ParameterBundle parameters);
	void revoke(String ruleId);
	int getVersion();
}