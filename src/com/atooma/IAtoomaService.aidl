package com.atooma;

import com.atooma.plugin.IModulePlugin;
import com.atooma.plugin.ParameterBundle;

interface IAtoomaService {
	void registerModule(in IModulePlugin module, boolean engineRestart);
	void trigger(String moduleId, String tirggerid, String ruleId, in ParameterBundle variables);
}