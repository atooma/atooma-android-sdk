package com.atooma.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.atooma.IAtoomaService;

public class AtoomaRegistrationReceiver extends BroadcastReceiver {

	protected static IAtoomaService mService;
	private boolean fromInstallBroadcast;

	@Override
	public void onReceive(Context context, Intent intent) {
		fromInstallBroadcast = intent.getExtras().getBoolean("fromInstallBroadcast");
		RegisterService.registerModule(fromInstallBroadcast);
		context.startService(new Intent(context, getRegisterServiceClass()));
	}
	
	public Class getRegisterServiceClass() {
		return RegisterService.class;
	}

}
