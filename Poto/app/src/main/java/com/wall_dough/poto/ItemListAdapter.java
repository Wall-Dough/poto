package com.wall_dough.poto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wall_dough.poto.models.items.lists.ListItem;

import java.util.List;

/**
 * Created by andrew on 6/1/16.
 */
public class ItemListAdapter extends ArrayAdapter<ListItem> {
    public ItemListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ItemListAdapter(Context context, int resource, List<ListItem> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.generic_list_item, null);
        }

        ListItem p = getItem(position);

        if (p != null) {
            TextView nameView = (TextView) v.findViewById(R.id.item_name);
            TextView contentView = (TextView) v.findViewById(R.id.item_content);

            nameView.setText(p.getName());
            contentView.setText(p.getContent());
        }

        return v;
    }
}
