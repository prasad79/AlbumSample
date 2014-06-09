package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ItemsList extends ListFragment {

    private static ItemsList _instance = null;
    private int type_of_list = Constants.ALBUM_LIST;


    public ItemsList(int type){
        type_of_list = type;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ItemsAdapter adapter = null;
        ArrayList<Item> dummies = null;

        if(type_of_list == Constants.ALBUM_LIST){
           adapter = new ItemsAdapter(Constants.getDummieAlbums(), getActivity());

        } else if(type_of_list == Constants.SONGS_LIST){
           adapter = new ItemsAdapter(Constants.getDummieSongs(), getActivity());

        } else if(type_of_list == Constants.ARTIST_LIST){
           adapter = new ItemsAdapter(Constants.getDummieArtists(), getActivity());
        }

        setListAdapter(adapter);
    }



}
