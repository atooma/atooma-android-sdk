package com.atooma.plugin;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.IBinder;

public abstract class Module extends IModulePlugin.Stub implements IModulePlugin {

	private List<IBinder> normalTriggers = new ArrayList<IBinder>();
	private List<IBinder> alarmTriggers = new ArrayList<IBinder>();
	private List<IBinder> intentTriggers = new ArrayList<IBinder>();
	private List<IBinder> conditionChekers = new ArrayList<IBinder>();
	private List<IBinder> performers = new ArrayList<IBinder>();
	private Context context;
	private int normalIcon;
	private int titleResource;
	private int pressedIcon;
	private int moduleVersion;
	private String moduleId;

	public Module(Context context, String moduleId, int moduleVersion) {
		this.context = context;
		this.moduleId = moduleId;
		this.moduleVersion = moduleVersion;
		registerComponents();
		defineUI();
	}

	@Override
	public boolean init() {
		return true;
	}

	@Override
	public String getId() {
		return moduleId;
	}

	@Override
	public int getVersion() {
		return moduleVersion;
	}

	public abstract void registerComponents();

	public abstract void defineUI();

	protected void registerTrigger(IntentBasedTrigger trIntent) {
		trIntent.setModuleId(getId());
		intentTriggers.add(trIntent.asBinder());
	}

	protected void registerTrigger(AlarmBasedTrigger trAlarm) {
		trAlarm.setModuleId(getId());
		alarmTriggers.add(trAlarm.asBinder());
	}

	protected void registerTrigger(Trigger trTrigger) {
		trTrigger.setModuleId(getId());
		normalTriggers.add(trTrigger.asBinder());
	}

	protected void registerConditionChecker(ConditionChecker conditionC) {
		conditionChekers.add(conditionC);
	}

	protected void registerPerformer(Performer performer) {
		performers.add(performer.asBinder());
	}

	@Override
	public List<IBinder> getTriggers() {
		return normalTriggers;
	}

	@Override
	public List<IBinder> getAlarmTriggers() {
		return alarmTriggers;
	}

	@Override
	public List<IBinder> getIntentTriggers() {
		return intentTriggers;
	}

	@Override
	public List<IBinder> getConditionCheckers() {
		return conditionChekers;
	}

	@Override
	public List<IBinder> getPerformers() {
		return performers;
	}

	@Override
	public IBinder asBinder() {
		return this;
	}

	@Override
	public String getPackage() {
		return context.getPackageName();
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

	public void setIcon(int normalIcon, int pressedIcon) {
		this.normalIcon = normalIcon;
		this.pressedIcon = pressedIcon;
	}

	@Override
	public void setCategory() {

	}

	@Override
	public int getIconResourceNormal() {
		return normalIcon;
	}

	@Override
	public int getIconResourcePressed() {
		return pressedIcon;
	}

	@Override
	public int getTitleResource() {
		return titleResource;
	}

}
