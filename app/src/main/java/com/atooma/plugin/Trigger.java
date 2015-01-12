package com.atooma.plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.atooma.IAtoomaPluginService;
import com.atooma.plugin.ITriggerPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class Trigger extends ITriggerPlugin.Stub implements ITriggerPlugin {

    protected IAtoomaPluginService mService;
    protected boolean bound;

    private Context context;
    private int normalIcon;
    private int titleResource;
    private int version;
    private String id;
    private String moduleId;

    private ArrayList<Values> variables = new ArrayList<Values>();
    private List<Integer> variableLabels = new ArrayList<Integer>();
    private ArrayList<Values> parameters = new ArrayList<Values>();
    private List<Integer> parameterLabels = new ArrayList<Integer>();
    private List<Integer> parameterNullLabels = new ArrayList<Integer>();

    public Trigger(Context context, String id, int version) {
        this.id = id;
        this.version = version;
        this.context = context;
        defineUI();
        declareParameters();
        declareVariables();
        if (!bound) {
            Intent i = new Intent();
            i.setClassName("com.atooma", "com.atooma.AtoomaPluginService");
            bound = context.bindService(i, mConnection, Context.BIND_AUTO_CREATE);
        }
    }

    public abstract void defineUI();

    public void declareParameters() {
    }

    public void declareVariables() {
    }

    public void trigger(String ruleId, ParameterBundle parameters) {
        if (bound) {
            try {
                mService.trigger(getModuleId(), getId(), ruleId, parameters);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
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

    public void invoke(String ruleId, ParameterBundle parameters) throws RemoteException {
        onInvoke(ruleId, parameters);
    }

    ;

    public abstract void onInvoke(String ruleId, ParameterBundle parameters);

    public void revoke(String ruleId) throws RemoteException {
        onRevoke(ruleId);
    }

    public abstract void onRevoke(String ruleId);

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

    public void addVariable(int labelResId, String name, String type) {
        Values value = new Values(name, type);
        variables.add(value);
        variableLabels.add(labelResId);
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
    public List<Values> getVariables() {
        return variables;
    }

    @Override
    public List getVariableTitleResources() {
        return variableLabels;
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
