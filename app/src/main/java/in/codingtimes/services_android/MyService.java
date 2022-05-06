package in.codingtimes.services_android;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );
        player.setLooping( true );
        player.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this, "Service Stop", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}