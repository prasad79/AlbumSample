package com.sample.album.common;

public class AlbumItem implements Item{
    private String name;
    private String genre;
    private String iconUrl;

    public AlbumItem(String name, String genre) {
     this.name = name;
     this.genre = genre;
     iconUrl = "album0.jpg"; //".png"
    }

    public String getMainHeader(){
        return name;
    }
    public String getSecondaryHeader(){
        return genre;
    }
    public String getIconUrl() { return iconUrl;}

}
