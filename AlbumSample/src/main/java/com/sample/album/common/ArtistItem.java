package com.sample.album.common;

public class ArtistItem implements Item{
    private String name;
    private String songCount;


    public ArtistItem(String name, String songCount) {
        this.name = name;
        this.songCount = songCount;
    }

    public String getMainHeader(){
        return name;
    }
    public String getSecondaryHeader(){
        return songCount;
    }

}
