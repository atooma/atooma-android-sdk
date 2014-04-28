// IRemoteService.aidl
package com.atooma.plugin;

import com.atooma.plugin.Values;
import com.atooma.plugin.ParameterBundle;

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