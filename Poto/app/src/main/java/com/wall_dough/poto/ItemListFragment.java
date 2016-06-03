package com.wall_dough.poto;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wall_dough.poto.models.items.lists.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemListFragment extends ListFragment {

    public class Category {
        public static final String FESTIVALS = "festivals";
        public static final String VENDORS = "vendors";
        public static final String FOOD = "food";
        public static final String DRINKS = "drinks";

    }

    private static final String TAG = ItemListFragment.class.getSimpleName();

    private FirebaseDatabase mDatabase;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CATEGORY = "category";

    // TODO: Rename and change types of parameters
    private String mCategory;

    public ItemListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param category The category.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemListFragment newInstance(String category) {
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_CATEGORY);
        }

        mDatabase = FirebaseDatabase.getInstance();
    }


    private void setItemListAdapter(ArrayList<ListItem> list) {
        ItemListAdapter adapter = new ItemListAdapter(MainActivity.getContext(), R.layout.generic_list_item, list);
        setListAdapter(adapter);
    }


    private void getItemList() {
        switch (mCategory) {
            case Category.VENDORS:
                // Get vendors list from database
                break;
            case Category.FOOD:
                // Get food list from database
                break;
            case Category.DRINKS:
                // Get drinks list from database
                break;
            case Category.FESTIVALS:
            default:
                // Get festivals list from database
                break;
        }

        mDatabase.getReference(mCategory).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        Log.d(TAG, "Data received");

                        ArrayList<ListItem> list = new ArrayList();
                        for (DataSnapshot child : children) {
                            ListItem item = new ListItem();
                            item.setName(child.child("name").getValue(String.class));
                            item.setContent(child.child("description").getValue(String.class));
                            item.setNumRatings(child.child("numRatings").getValue(Integer.class));
                            item.setRating(child.child("rating").getValue(Integer.class));
                            list.add(item);
                        }

                        setItemListAdapter(list);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        getItemList();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
