package com.example.mohamed.onsignalapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OSNotificationReceivedResult;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

import org.json.JSONException;

/**
 * Created by mohamed mabrouk
 * 0201152644726
 * on 06/12/2017.  time :11:06
 */

public class MyApp extends Application {
 public static OSNotificationReceivedResult receivedResult;
    @Override
    public void onCreate() {
        super.onCreate();



        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .autoPromptLocation(true)
                .setNotificationOpenedHandler(new OneSignal.NotificationOpenedHandler() {
                    @Override
                    public void notificationOpened(OSNotificationOpenResult result) {
                        String id= TextUtils.isEmpty(result.action.actionID)?"not":result.action.actionID;
                        try {
                             if (id.equals("1")){
                                 Log.d("open"," confirm   "+receivedResult.payload.additionalData.get("name").toString());

                             }else if (id.equals("2")){
                                 Log.d("open"," cancel   "+receivedResult.payload.additionalData.get("name").toString());

                             }else if (id.equals("not")){
                                 Log.d("open", "no way " + "");
                             }
                         }catch (Exception e){}
                    }

                })
                .init();

         OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            @Override
            public void idsAvailable(String userId, String registrationId) {
                Log.d("myid", userId + "");
            }
        });




    }

}
