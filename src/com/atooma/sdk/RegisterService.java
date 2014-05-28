package com.atooma.sdk;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.atooma.IAtoomaPluginService;
import com.atooma.plugin.IModulePlugin;

public abstract class RegisterService extends Service {

	private boolean bound = false;
	private IAtoomaPluginService mService;
	private ServiceConnection mConnection;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v("ATOOMAPLUGIN", "onStartCommand");

		mConnection = new ServiceConnection() {

			public void onServiceConnected(ComponentName className, IBinder service) {
				Log.v("ATOOMA", "onServiceConnected");
				mService = IAtoomaPluginService.Stub.asInterface(service);
				bound = true;

				IModulePlugin mModule = getModuleInstance();

				if (bound && mModule != null) {
					try {
						mService.registerModule(mModule);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.v("ATOOMA", "onServiceDisconnected");
				bound = false;
			}
		};

		if (!bound) {
			Intent i = new Intent();
			i.setClassName("com.atooma", "com.atooma.AtoomaPluginService");
			bound = bindService(i, mConnection, Context.BIND_AUTO_CREATE);
			Log.v("ATOOMAPLUGIN", "try to bind, bound=" + bound);
		}
		return START_STICKY;
	}

	public abstract IModulePlugin getModuleInstance();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
