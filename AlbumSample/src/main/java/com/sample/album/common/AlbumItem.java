package com.sample.album.common;

public class AlbumItem implements Item{
    private String name;
    private String genre;

    public AlbumItem(String name, String genre) {
     this.name = name;
     this.genre = genre;
    }

    public String getMainHeader(){
        return name;
    }
    public String getSecondaryHeader(){
        return genre;
    }

}
