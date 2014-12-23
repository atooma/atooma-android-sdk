package com.atooma.sdk.plugin;

import java.util.ArrayList;
import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.atooma.sdk.IAtoomaPluginService;

public abstract class ConditionChecker extends IConditionCheckerPlugin.Stub implements IConditionCheckerPlugin {

	protected IAtoomaPluginService mService;
	protected boolean bound;

	private Context context;
	private int normalIcon;
	private int titleResource;
	private int version;
	private String id;
	private String moduleId;

	private ArrayList<Values> parameters = new ArrayList<Values>();
	private List<Integer> parameterLabels = new ArrayList<Integer>();
	private List<Integer> parameterNullLabels = new ArrayList<Integer>();

	public ConditionChecker(Context context, String id, int version) {
		this.id = id;
		this.version = version;
		this.context = context;
		defineUI();
		declareParameters();
		if (!bound) {
			Intent i = new Intent();
			i.setClassName("com.atooma", "com.atooma.AtoomaPluginService");
			bound = context.bindService(i, mConnection, Context.BIND_AUTO_CREATE);
		}
	}

	public abstract void defineUI();

	public void declareParameters() {
	}

	public ServiceConnection mConnection = new ServiceConnection() {

		public void onServiceConnected(ComponentName className, IBinder service) {
			mService = IAtoomaPluginService.Stub.asInterface(service);
			bound = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			bound = false;
		}
	};

	public boolean invoke(String ruleId, ParameterBundle parameters) {
		return onInvoke(ruleId, parameters);
	};

	public abstract boolean onInvoke(String ruleId, ParameterBundle parameters);

	@Override
	public IBinder asBinder() {
		return this;
	}

	public void addParameter(int labelResId, int labelNullResId, String name, String type, boolean isRequired, String activity) {
		Values value = new Values(name, type, isRequired, activity);
		parameters.add(value);
		parameterLabels.add(labelResId);
		parameterNullLabels.add(labelNullResId);
	}

	@Override
	public List<Values> getParameters() {
		return parameters;
	}

	@Override
	public List getParameterLabelIfNullResources() {
		return parameterNullLabels;
	}

	@Override
	public List getParameterTitleResources() {
		return parameterLabels;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	public Context getContext() {
		return context;
	}

	public void setTitle(int titleResource) {
		this.titleResource = titleResource;
	}

	public void setIcon(int normalIcon) {
		this.normalIcon = normalIcon;
	}

	@Override
	public int getIconResourceNormal() {
		return normalIcon;
	}

	@Override
	public int getTitleResource() {
		return titleResource;
	}

	@Override
	public int getVersion() {
		return version;
	}

	String getModuleId() {
		return moduleId;
	}

	void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

}
