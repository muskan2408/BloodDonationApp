//package com.startupnationgo.blooddonationapp;
//
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.NotificationCompat;
//import android.util.Log;
//
//import com.google.android.gms.gcm.GcmListenerService;
//import com.startupnationgo.blooddonationapp.NotificationFragment;
//
//public class MyFirebaseMessagingService extends GcmListenerService {
//
//    private static final String TAG = "MyGcmListenerService";
//
//    /**
//     * Called when message is received.
//     *
//     * @param from SenderID of the sender.
//     * @param data Data bundle containing message data as key/value pairs.
//     *             For Set of keys use data.keySet().
//     */
//    // [START receive_message]
//    @Override
//    public void onMessageReceived(String from, Bundle data) {
////        String message = data.getString("message");
////        Log.d(TAG, "From: " + from);
////        Log.d(TAG, "Message: " + message);
////
////        if (from.startsWith("/topics/")) {
////            // message received from some topic.
////        } else {
////            // normal downstream message.
////        }
////
////        // [START_EXCLUDE]
////        /**
////         * Production applications would usually process the message here.
////         * Eg: - Syncing with server.
////         *     - Store message in local database.
////         *     - Update UI.
////         */
////
////        /**
////         * In some cases it may be useful to show a notification indicating to the user
////         * that a message was received.
////         */
////        sendNotification(message);
////        // [END_EXCLUDE]
//
//    }
//    // [END receive_message]
//
//    /**
//     * Create and show a simple notification containing the received GCM message.
//     *
//     * @param message GCM message received.
//     */
//    private void sendNotification(String message) {
//        Intent intent = new Intent(this, NotificationFragment.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("GCM Message")
//                .setContentText(message)
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
//    }
//}











package com.startupnationgo.blooddonationapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Jarvis on 15-07-2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("FirebasemessageService", "FROM:" + remoteMessage.getFrom());

        //Check if the message contains data
        if(remoteMessage.getData().size() > 0) {
            Log.d("FirebasemessageService", "Message data: " + remoteMessage.getData());
        }

        //Check if the message contains notification

        if(remoteMessage.getNotification() != null) {
            Log.d("FirebasemessageService", "Message body:" + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }
    private void sendNotification(String body) {

        Intent intent=new Intent(MyFirebaseMessagingService.this,Notification.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0/*Request code*/, intent, PendingIntent.FLAG_ONE_SHOT);
        //Set sound of notification
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.blood)
                .setContentTitle("Blood Request")
                .setContentText(body)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 , notifiBuilder.build());

//        Intent i=new Intent(MyFirebaseMessagingService.this,NotificationFragment.class);
//        startActivity(i);
    }
}