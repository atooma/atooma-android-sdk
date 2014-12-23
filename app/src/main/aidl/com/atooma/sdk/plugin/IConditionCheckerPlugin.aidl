// IRemoteService.aidl
package com.atooma.sdk.plugin;

import com.atooma.sdk.plugin.Values;
import com.atooma.sdk.plugin.ParameterBundle;

interface IConditionCheckerPlugin {
	boolean isVisible();
	String getId();
	List<Values> getParameters();
	int getTitleResource();
	int getIconResourceNormal();
	List getParameterLabelIfNullResources();
	List getParameterTitleResources();
	boolean invoke(String ruleId, in ParameterBundle parameters);
	int getVersion();
}