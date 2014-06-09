package com.sample.album;

import android.app.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.sample.album.common.Constants;
import com.sample.album.common.ItemsList;


public class AlbumSampleMain extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_sample_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();

        ItemsList itemsList = ItemsList.getInstance();
        itemsList.setItemType(position);
        fragmentManager.beginTransaction()
                .replace(R.id.container, itemsList)
                .commit();

        getActionBar().setTitle(Constants.TITLE[position]);

       // System.out.println("Item at " + position + " selected");
    }
}
