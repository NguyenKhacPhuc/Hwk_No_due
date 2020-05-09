package com.example.hwk_no_due;

public class MusicHolder
{
    private int thumbnail;
    private String songName;
    private String artist;
    private String duration;
    private boolean play;

    public MusicHolder(int thumbnail, String songName, String artist, String duration, boolean play) {
        this.thumbnail = thumbnail;
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
        this.play = play;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
}
