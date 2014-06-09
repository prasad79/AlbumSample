package com.sample.album.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fedorvlasov.lazylist.ImageLoader;
import com.sample.album.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ItemsAdapter extends BaseAdapter {
    private ArrayList<Item> items;
    private Context mContext;
    public ImageLoader imageLoader;

    public ItemsAdapter(ArrayList<Item> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
        imageLoader=new ImageLoader(mContext.getApplicationContext());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Item item = (Item) getItem(i);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item, parent, false);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.imageView = ((ImageView) convertView.findViewById(R.id.icon));
            holder.textViewMain = ((TextView) convertView.findViewById(R.id.main_header));
            holder.textViewSecondary =  ((TextView) convertView.findViewById(R.id.secondary_header));
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewMain.setText(item.getMainHeader());
        holder.textViewSecondary.setText(item.getSecondaryHeader());
        imageLoader.DisplayImage(Constants.ICON_FOLDER_URL + item.getIconUrl(), holder.imageView);
        return convertView;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static class ViewHolder {

        ImageView imageView;
        TextView textViewMain;
        TextView textViewSecondary;

    }
}
