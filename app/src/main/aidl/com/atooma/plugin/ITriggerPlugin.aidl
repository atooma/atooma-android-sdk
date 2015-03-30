// IRemoteService.aidl
package com.atooma.plugin;

import com.atooma.plugin.Values;
import com.atooma.plugin.ParameterBundle;
import com.atooma.sdk.IAtoomaService;

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
	void invoke(in IAtoomaService atoomaService, String ruleId, in ParameterBundle parameters);
	void revoke(String ruleId);
	int getVersion();
}