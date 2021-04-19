package co.sandyedemo.ecomdemo.FCM;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import co.sandyedemo.ecomdemo.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public  String ANDROID_CHANNEL_ID = null;
    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();
        private Context mContext;
    String value, type;
    int count = 0;
    NotificationManager notificationManager;
    String placeImage, placeId, placeTitle, placeMessage;
    String random_id;
    public static int NOTIFICATION_ID = 0;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        mContext=getApplicationContext();
        ANDROID_CHANNEL_ID=getApplicationContext().getPackageName();
        if (remoteMessage == null)
            return;

        notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Map<String, String> data=remoteMessage.getData();
        placeImage = data.get("image");
        placeTitle = data.get("title");
        placeMessage = data.get("message");
        placeId = data.get("product_id");
        random_id = data.get("random_id");
        //Log.d("placeId", placeId);
        if (NOTIFICATION_ID != Integer.parseInt(random_id)) {
            NOTIFICATION_ID= Integer.parseInt(random_id);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();


            notificationManager.notify(0 /* ID of notification */,  getAndroidChannelNotification(placeTitle,placeMessage).build());
        }else{

            createNotification(remoteMessage);
        }

    }
    private void createNotification(RemoteMessage remoteMessage) {

        Bitmap remote_picture = null;
        int icon = R.drawable.appicon;
        //if message and image url
        if (placeMessage != null && placeImage != null) {


            Log.v("TAG_MESSAGE", "" + placeMessage);
            Log.v("TAG_IMAGE", "" + placeImage);
//                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                notificationManager.cancel(NOTIFICATION_ID);

            NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();
            notiStyle.setSummaryText(placeMessage);

            try {
                remote_picture = BitmapFactory.decodeStream((InputStream) new URL(placeImage).getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            notiStyle.bigPicture(remote_picture);
            notificationManager = (NotificationManager) mContext
                    .getSystemService(Context.NOTIFICATION_SERVICE);
        }
        PendingIntent contentIntent = null;

        Intent gotoIntent = new Intent();
        gotoIntent.putExtra("id", placeId);
        gotoIntent.setClassName(mContext, getApplicationContext().getPackageName()+".Activities.SplashScreen");//Start activity when user taps on notification.
        contentIntent = PendingIntent.getActivity(mContext,
                (int) (Math.random() * 100), gotoIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);





        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, ADMIN_CHANNEL_ID)

        Notification.Builder mBuilder = new Notification.Builder(
                mContext);
        Notification notification = mBuilder
                .setSmallIcon(R.drawable.appicon).setTicker(placeTitle).setWhen(0)
                .setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.drawable.appicon)).getBitmap())
                .setAutoCancel(true)
                .setContentTitle(placeTitle)
                .setPriority(Notification.PRIORITY_HIGH)
                // .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setStyle(new Notification.BigPictureStyle()
                        .bigPicture(remote_picture)
                        .setBigContentTitle(placeTitle))
                .setContentIntent(contentIntent)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentText(placeMessage).build();
        // .setStyle(notiStyle).build();

        notificationManager.notify(0   , notification);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels() {

        // create android channel
        NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        notificationManager.createNotificationChannel(androidChannel);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getAndroidChannelNotification(String title, String message) {
        Bitmap remote_picture = null;
        int icon = R.drawable.appicon;
        //if message and image url
        if (placeMessage != null && placeImage != null) {


                Log.v("TAG_MESSAGE", "" + placeMessage);
                Log.v("TAG_IMAGE", "" + placeImage);
//                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                notificationManager.cancel(NOTIFICATION_ID);

                NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();
                notiStyle.setSummaryText(placeMessage);

                try {
                    remote_picture = BitmapFactory.decodeStream((InputStream) new URL(placeImage).getContent());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                notiStyle.bigPicture(remote_picture);

            }
                PendingIntent contentIntent = null;

                Intent gotoIntent = new Intent();
                gotoIntent.putExtra("id", placeId);
                gotoIntent.setClassName(mContext, getApplicationContext().getPackageName()+".Activities.SplashScreen");//Start activity when user taps on notification.
                contentIntent = PendingIntent.getActivity(mContext,
                        (int) (Math.random() * 100), gotoIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);




        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.appicon).setTicker(placeTitle).setWhen(0)
                .setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.drawable.appicon)).getBitmap())
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(contentIntent)
                .setStyle(new Notification.BigPictureStyle()
                        .bigPicture(remote_picture)
                        .setBigContentTitle(placeTitle))
                ;
    }

}