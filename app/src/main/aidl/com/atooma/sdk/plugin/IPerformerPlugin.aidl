// IRemoteService.aidl
package com.atooma.sdk.plugin;

import com.atooma.sdk.plugin.Values;
import com.atooma.sdk.plugin.ParameterBundle;

interface IPerformerPlugin {
	boolean isVisible();
	String getId();
	int getVersion();
	List<Values> getParameters();
	List<Values> getVariables();
    ParameterBundle onInvoke(String ruleId, in ParameterBundle parameters);
	int getTitleResource();
	int getIconResourceNormal();
	List getParameterLabelIfNullResources();
	List getParameterTitleResources();
	List getVariableTitleResources();
}