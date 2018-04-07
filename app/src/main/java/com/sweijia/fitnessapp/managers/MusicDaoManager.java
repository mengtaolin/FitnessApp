package com.sweijia.fitnessapp.managers;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.sweijia.fitnessapp.daos.MusicDao;

import java.util.ArrayList;
import java.util.List;

public class MusicDaoManager {
    private static MusicDaoManager instance;
    private List<MusicDao> musicList;
    private Context _context;
    private Cursor _cursor;

    public MusicDaoManager(Context context) {
        if(instance != null){
            throw new Error("MusicDaoManager is single instance");
        }
        _context = context;
        musicList  = new ArrayList<MusicDao>();
        this.init();
    }

    public static MusicDaoManager getInstance(Context context){
        if(instance == null){
            instance = new MusicDaoManager(context);
        }
        return instance;
    }

    private void init(){
        try{
            _cursor = _context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                    , null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);
            if (_cursor != null) {
                while (_cursor.moveToNext()) {
                    MusicDao dao = new MusicDao();
                    dao.setDisplayName(_cursor.getString(getIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
                    dao.setArtist(_cursor.getString(getIndex(MediaStore.Audio.Media.ARTIST)));
                    dao.setUri(_cursor.getString(getIndex(MediaStore.Audio.Media.DATA)));
                    dao.setDuration(_cursor.getInt(getIndex(MediaStore.Audio.Media.DURATION)));
                    dao.setSize(_cursor.getLong(getIndex(MediaStore.Audio.Media.SIZE)));
                    musicList.add(dao);
                }
                _cursor.close();
            }

        }
        catch(Exception e){
            System.out.print("错误");
        }
    }

    private int getIndex(String key){
        return _cursor.getColumnIndex(key);
    }

    public List<MusicDao> getMusicList() {
        return musicList;
    }
}
