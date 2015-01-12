package com.atooma.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.atooma.IAtoomaPluginService;

public class AtoomaRegistrationReceiver extends BroadcastReceiver {

    protected static IAtoomaPluginService mService;

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, getRegisterServiceClass()));
    }

    public Class getRegisterServiceClass() {
        return RegisterService.class;
    }

}
