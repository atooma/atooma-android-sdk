package com.atooma.sdk;

import com.atooma.plugin.IModulePlugin;
import com.atooma.plugin.ParameterBundle;

interface IAtoomaService {
    void connectToModule(String packageName, String servicePackage);
	void addModule(in IModulePlugin mp, boolean replace, String packageName);
	void trigger(String moduleId, String triggerId, String ruleId, in ParameterBundle variables);
}