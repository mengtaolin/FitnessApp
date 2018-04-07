package com.sweijia.fitnessapp.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.sweijia.fitnessapp.daos.MusicDao;
import com.sweijia.fitnessapp.managers.MusicDaoManager;

import java.util.List;

public class MusicService extends Service {
    private List<MusicDao> musicList;
    public final IBinder binder = new MyBinder();
    public class MyBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private int musicIndex = 1;

    public static MediaPlayer mp = new MediaPlayer();
    public MusicService() {
        try {
            musicList = MusicDaoManager.getInstance(this).getMusicList();
            if(musicList.size() == 0) {
                return;
            }
            musicIndex = (int) Math.floor(Math.random() * musicList.size());
            mp.setDataSource(musicList.get(musicIndex).getUri());
            mp.prepare();
        } catch (Exception e) {
            Log.d("hint","can't get to the song");
            e.printStackTrace();
        }
    }
    public void playOrPause() {
        if(mp.isPlaying()){
            mp.pause();
        } else {
            mp.start();
        }
    }
    public void stop() {
        if(mp != null) {
            mp.stop();
            try {
                mp.prepare();
                mp.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void nextMusic() {
        if(mp != null && musicIndex > 2) {
            musicIndex = 0;
        }
        mp.stop();
        try {
            mp.reset();
            mp.setDataSource(musicList.get(++musicIndex).getUri());
            mp.prepare();
            mp.seekTo(0);
            mp.start();
        } catch (Exception e) {
            Log.d("hint", "can't jump next music");
            e.printStackTrace();
        }
    }
    public void preMusic() {
        if(mp != null && musicIndex < 0) {
            musicIndex = musicList.size() - 1;
        }
        mp.stop();
        try {
            mp.reset();
            mp.setDataSource(musicList.get(--musicIndex).getUri());
            mp.prepare();
            mp.seekTo(0);
            mp.start();
        } catch (Exception e) {
            Log.d("hint", "can't jump pre music");
            e.printStackTrace();
        }
    }

}
