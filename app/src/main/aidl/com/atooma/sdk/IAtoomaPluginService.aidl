package com.atooma.sdk;

import com.atooma.sdk.plugin.IModulePlugin;
import com.atooma.sdk.plugin.ParameterBundle;

interface IAtoomaPluginService {
	void registerModule(in IModulePlugin module);
	void trigger(String moduleId, String tirggerid, String ruleId, in ParameterBundle variables);
}