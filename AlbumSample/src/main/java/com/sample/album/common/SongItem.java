package com.sample.album.common;

public class SongItem implements Item{
    private String title;
    private String artist;
    private String iconUrl;

    public SongItem(String title, String artist) {
        this.title = title;
        this.artist = artist;
        iconUrl = "song0.jpg"; //".png"
    }

    public String getMainHeader(){
        return title;
    }
    public String getSecondaryHeader(){
        return artist;
    }
    public String getIconUrl() { return iconUrl;}
}
