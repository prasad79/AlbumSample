package com.sample.album.common;

import java.util.ArrayList;
import java.util.Random;

public abstract class Constants {

    public static final int ALBUM_LIST = 0;
    public static final int SONGS_LIST = 1;
    public static final int ARTIST_LIST = 2;

    public static final String [] TITLE = {"Albums", "Songs", "Artists"};

    public static final String ICON_FOLDER_URL = "http://www.enefce.com/icons/"; // replace this url
    private static ArrayList<Item> dummieAlbums = null;
    private static ArrayList<Item> dummieSongs = null;
    private static ArrayList<Item> dummieArtists = null;

    public static ArrayList getDummieAlbums() {
        if (dummieAlbums == null) {
            dummieAlbums = new ArrayList<Item>();
            for (int i = 0; i < 10000; i++) {
                Item item = new AlbumItem("Album " + i, "Genre " + i, "album" + i + ".jpg");
                dummieAlbums.add(item);
            }
        }
        return dummieAlbums;
    }

    public static ArrayList getDummieSongs() {
        if (dummieSongs == null) {
            dummieSongs = new ArrayList<Item>();
            for (int i = 0; i < 10000; i++) {
                Item item =  new SongItem("Song " + i, "Artist " + i, "song"+i+".jpg");
                dummieSongs.add(item);
            }
        }
        return dummieSongs;
    }
    public static ArrayList getDummieArtists() {

        if (dummieArtists == null) {
            Random random = new Random();
            dummieArtists = new ArrayList<Item>();
            for (int i = 0; i < 10000; i++) {
                Item item =  new ArtistItem("Artist " + i, "Total songs " + random.nextInt(50), "artist"+i+".jpg");
                dummieArtists.add(item);
            }
        }
        return dummieArtists;
    }
}
