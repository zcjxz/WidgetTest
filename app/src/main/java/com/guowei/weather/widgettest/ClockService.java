package com.guowei.weather.widgettest;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClockService extends Service{

    private Timer timer;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("zcj", "Service onCreate");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        },0,1000);
    }

    private void updateClock() {
        String time = sdf.format(new Date());
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.layout_widget);
        remoteViews.setTextViewText(R.id.widget_text,time);
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(getApplication());
        widgetManager.updateAppWidget(new ComponentName(getApplication(),MyWidgetProvider.class),remoteViews);
        Log.i("zcj", "updateClock: -------");
//        this.sendBroadcast(new Intent("zcj"));
//        Log.i("zcj", "updateClock");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer=null;
    }
}
