package com.atooma;

import com.atooma.plugin.IModulePlugin;
import com.atooma.plugin.ParameterBundle;

interface IAtoomaPluginService {
	void registerModule(in IModulePlugin module);
	void trigger(String moduleId, String tirggerid, String ruleId, in ParameterBundle variables);
}