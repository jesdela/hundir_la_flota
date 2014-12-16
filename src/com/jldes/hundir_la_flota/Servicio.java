package com.jldes.hundir_la_flota;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.jldes.hundir_la_flota.R;

public class Servicio extends Service {
	 
    public static MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
 
    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.bsopiratasdelcaribe);
        player.setLooping(true);
    }
    
    @Override
    public void onDestroy() {
        player.stop();
    }
 
    @Override
    public void onStart(Intent intent, int startid) {
       player.start();
    }
 
}
