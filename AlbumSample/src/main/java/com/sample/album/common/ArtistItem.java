package com.sample.album.common;

public class ArtistItem implements Item{
    private String name;
    private String songCount;
    private String iconUrl;



    public ArtistItem(String name, String songCount) {
        this.name = name;
        this.songCount = songCount;
        iconUrl = "artist0.jpg"; //".png"
    }

    public String getMainHeader(){
        return name;
    }
    public String getSecondaryHeader(){
        return songCount;
    }
    public String getIconUrl() { return iconUrl;}

}
