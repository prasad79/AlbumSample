package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ItemsList extends ListFragment {

    private int type_of_list = Constants.ALBUM_LIST;
    ArrayList<Item> dummieAlbums = null;
    ArrayList<Item> dummieSongs = null;
    ArrayList<Item> dummieArtists = null;

    public ItemsList(int type){
        type_of_list = type;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random random = new Random();

        // Generate a list of 100000 dummy items
        ArrayList<Item> dummies = new ArrayList<Item>();
        ItemsAdapter adapter = null;
        if(type_of_list == Constants.ALBUM_LIST){
            if(dummieAlbums == null){
                dummieAlbums = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new AlbumItem("Album " + i, "Genre " + i);
                    dummieAlbums.add(item);
                }
            }

             adapter = new ItemsAdapter(dummieAlbums, getActivity());

        } else if(type_of_list == Constants.SONGS_LIST){
            if(dummieSongs == null){
                dummieSongs = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new SongItem("Song " + i, "Artist " + i);
                    dummieSongs.add(item);
                }
            }
             adapter = new ItemsAdapter(dummieSongs, getActivity());

        } else if(type_of_list == Constants.ARTIST_LIST){
            if(dummieArtists == null){
                dummieArtists = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new ArtistItem("Artist " + i, "Total songs " + random.nextInt(50));
                    dummieArtists.add(item);
                }
            }
             adapter = new ItemsAdapter(dummieArtists, getActivity());
        }


        setListAdapter(adapter);
    }



}
