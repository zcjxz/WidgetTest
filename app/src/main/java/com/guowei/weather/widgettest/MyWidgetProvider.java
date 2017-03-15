package com.guowei.weather.widgettest;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyWidgetProvider extends AppWidgetProvider{
    String TAG="zcj";
    SimpleDateFormat sdf;
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(TAG, "onUpdate: ");
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.i(TAG, "onAppWidgetOptionsChanged: ");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "onDeleted: ");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        Log.i(TAG, "onEnabled: ");
        context.startService(new Intent(context,ClockService.class));
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG, "onDisabled: ");
        context.stopService(new Intent(context,ClockService.class));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("zcj")){
            Log.i(TAG, "onReceive: ");
//            sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time = sdf.format(new Date());
//            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.layout_widget);
//            remoteViews.setTextViewText(R.id.widget_text,time);
//            ComponentName componentName = new ComponentName(context, MyWidgetProvider.class);
//            AppWidgetManager.getInstance(context).updateAppWidget(componentName,remoteViews);
        }
        super.onReceive(context, intent);
    }
}
