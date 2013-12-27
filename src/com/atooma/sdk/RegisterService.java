package com.atooma.sdk;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.atooma.IAtoomaService;
import com.atooma.plugin.IModulePlugin;

public abstract class RegisterService extends Service {

	private boolean bound = false;
	private IAtoomaService mService;
	private ServiceConnection mConnection;
	private static Boolean mFromInstallBroadcast = false;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mConnection = new ServiceConnection() {

			public void onServiceConnected(ComponentName className, IBinder service) {
				mService = IAtoomaService.Stub.asInterface(service);
				bound = true;

				IModulePlugin mModule = getModuleInstance();

				if (bound && mModule != null) {
					try {
						mService.registerModule(mModule, mFromInstallBroadcast);
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
			i.setClassName("com.atooma", "com.atooma.AtoomaService");
			bound = bindService(i, mConnection, Context.BIND_AUTO_CREATE);
		}
		return super.onStartCommand(intent, flags, startId);
	}

	public abstract IModulePlugin getModuleInstance();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public static void registerModule(Boolean fromInstallBroadcast) { //TODO stoppare service
		mFromInstallBroadcast = fromInstallBroadcast;
	}
}
