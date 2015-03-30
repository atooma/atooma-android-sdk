package com.atooma.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.atooma.plugin.IModulePlugin;

public abstract class AtoomaPluginService extends Service {

    public static final String INTENT_PLUGIN_PACKAGE_ACTION = "com.atooma.plugin.PACKAGE";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent packageName = new Intent(INTENT_PLUGIN_PACKAGE_ACTION);
        packageName.putExtra("package", getPackageName());
        packageName.putExtra("servicePackage", this.getClass().getName());
        sendOrderedBroadcast(packageName, null);
        return START_STICKY;
    }

    public abstract IModulePlugin getModuleInstance();

    @Override
    public IBinder onBind(Intent intent) {
        return new IAtoomaPluginService.Stub() {

            @Override
            public IModulePlugin getModule() throws RemoteException {
                return getModuleInstance();
            }
        };
    }
}
