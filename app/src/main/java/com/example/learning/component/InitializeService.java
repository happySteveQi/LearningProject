package com.example.learning.component;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class InitializeService extends IntentService {
    private static final String ACTION_INIT = "initApplication";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public InitializeService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }
}
