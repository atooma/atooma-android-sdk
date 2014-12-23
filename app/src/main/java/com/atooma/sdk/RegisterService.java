package com.atooma.sdk;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.atooma.sdk.plugin.IModulePlugin;

public abstract class RegisterService extends Service {

	private boolean bound = false;
	private IAtoomaPluginService mService;
	private ServiceConnection mConnection;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v("ATOOMSDK", "onStartCommand RegisterService");
		mConnection = new ServiceConnection() {

			public void onServiceConnected(ComponentName className, IBinder service) {
				Log.v("ATOOMSDK", "onServiceConnected");

				mService = IAtoomaPluginService.Stub.asInterface(service);
				bound = true;

				IModulePlugin mModule = getModuleInstance();

				if (bound && mModule != null) {
					try {
						Log.v("ATOOMSDK", "registerModule RegisterService");
						mService.registerModule(mModule);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				bound = false;
			}
		};

		if (!bound) {
			Intent i = new Intent();
			i.setClassName("com.atooma", "com.atooma.sdk.AtoomaPluginService");
			bound = bindService(i, mConnection, Context.BIND_AUTO_CREATE);
			Log.v("ATOOMSDK", "bindService, bound =" + bound);

		}
		return START_STICKY;
	}

	public abstract IModulePlugin getModuleInstance();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
