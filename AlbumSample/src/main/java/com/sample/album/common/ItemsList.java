package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ItemsList extends ListFragment {

    private static ItemsList _instance = null;
    private int type_of_list = Constants.ALBUM_LIST;
    ArrayList<Item> dummieAlbums = null;
    ArrayList<Item> dummieSongs = null;
    ArrayList<Item> dummieArtists = null;

    private ItemsList(){
    }



    public static ItemsList getInstance() {
        if(_instance == null)
          _instance =  new ItemsList();

        return _instance;
    }

    public void setItemType(int type){
        // Generate a list of 10000 dummy items
        Random random = new Random();

        type_of_list = type;
        if(type_of_list == Constants.ALBUM_LIST){
            if(dummieAlbums == null){
                dummieAlbums = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new AlbumItem("Album " + i, "Genre " + i, "album"+i+".jpg");
                    dummieAlbums.add(item);
                }
            }


        } else if(type_of_list == Constants.SONGS_LIST){
            if(dummieSongs == null){
                dummieSongs = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new SongItem("Song " + i, "Artist " + i, "song"+i+".jpg");
                    dummieSongs.add(item);
                }
            }

        } else if(type_of_list == Constants.ARTIST_LIST){
            if(dummieArtists == null){
                dummieArtists = new ArrayList<Item>();
                for (int i = 0; i < 10000; i++){
                    Item item =  new ArtistItem("Artist " + i, "Total songs " + random.nextInt(50), "artist"+i+".jpg");
                    dummieArtists.add(item);
                }
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ItemsAdapter adapter = null;

        if(type_of_list == Constants.ALBUM_LIST){

            adapter = new ItemsAdapter(dummieAlbums, getActivity());

        } else if(type_of_list == Constants.SONGS_LIST){
           adapter = new ItemsAdapter(dummieSongs, getActivity());

        } else if(type_of_list == Constants.ARTIST_LIST){
            adapter = new ItemsAdapter(dummieArtists, getActivity());
        }

        setListAdapter(adapter);
    }



}
