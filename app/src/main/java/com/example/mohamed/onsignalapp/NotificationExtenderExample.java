package com.example.mohamed.onsignalapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSNotificationReceivedResult;
import com.onesignal.OneSignal;

import org.json.JSONException;

import java.math.BigInteger;

/**
 * Created by mohamed mabrouk
 * 0201152644726
 * on 06/12/2017.  time :16:36
 */

public class NotificationExtenderExample extends NotificationExtenderService {
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        try {
            MyApp.receivedResult=notification;
            Log.d("asas", notification.payload.additionalData.get("name") + "");
            Result.getInstance().setmsg(notification.payload.additionalData.toString());

            Log.d("show",notification.payload.toJSONObject().toString(4));

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        OverrideSettings overrideSettings=new OverrideSettings();
//        overrideSettings.extender=new NotificationCompat.Extender() {
//            @Override
//            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
//                Bitmap icon= BitmapFactory.decodeResource(MyApp.getContext().getResources(),
//                        R.drawable.common_full_open_on_phone);
//                builder.setLargeIcon(icon);
//                return builder.setColor(new BigInteger("FF0000FF", 16).intValue());
//            }
//        };
//
//        OSNotificationDisplayedResult osNotificationDisplayedResult=displayNotification(overrideSettings);
        return false;
    }
}
