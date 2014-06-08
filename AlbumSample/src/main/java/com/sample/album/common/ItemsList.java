package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ItemsList extends ListFragment {

    private int type_of_list = Constants.ALBUM_LIST;

    public ItemsList(int type){
        type_of_list = type;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random random = new Random();

        // Generate a list of 1000 dummy items
        ArrayList<Item> dummies = new ArrayList<Item>();


        for (int i = 0; i < 100000; i++){
            Item item = null;
            if(type_of_list == Constants.ALBUM_LIST)
             item = new AlbumItem("Album " + i, "Genre " + i);
            else if(type_of_list == Constants.SONGS_LIST)
                item = new SongItem("Song " + i, "Artist " + i);
            else if(type_of_list == Constants.ARTIST_LIST)
                item = new ArtistItem("Artist " + i, "Total songs " + random.nextInt(50));
            dummies.add(item);
        }

        ItemsAdapter adapter = new ItemsAdapter(dummies, getActivity());
        setListAdapter(adapter);
    }



}
