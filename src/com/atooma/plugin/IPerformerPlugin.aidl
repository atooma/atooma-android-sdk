// IRemoteService.aidl
package com.atooma.plugin;

import com.atooma.plugin.Values;
import com.atooma.plugin.ParameterBundle;

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