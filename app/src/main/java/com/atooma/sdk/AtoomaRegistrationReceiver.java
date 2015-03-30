package com.atooma.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AtoomaRegistrationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, getRegisterServiceClass()));
    }

    public Class getRegisterServiceClass() {
        return AtoomaPluginService.class;
    }

}
