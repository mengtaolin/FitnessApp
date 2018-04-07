package com.sweijia.fitnessapp.daos;

public class MusicDao {
    // id title singer data time image
    private int id; // 音乐id
    private String displayName; // 音乐标题
    private String uri; // 音乐路径
    private int duration; // 长度
    private String image; // icon
    private String artist; // 艺术家
    private Long size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String formatTime() {
        if (duration / 1000 % 60 < 10) {
            String tt = duration / 1000 / 60 + ":0" + duration / 1000 % 60;
            return tt;
        } else {
            String tt = duration / 1000 / 60 + ":" + duration / 1000 % 60;
            return tt;
        }
    }
}
