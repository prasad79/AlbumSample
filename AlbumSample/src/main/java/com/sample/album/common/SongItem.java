package com.sample.album.common;

public class SongItem implements Item{
    private String title;
    private String artist;

    public SongItem(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getMainHeader(){
        return title;
    }
    public String getSecondaryHeader(){
        return artist;
    }
}
