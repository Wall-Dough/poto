package com.wall_dough.poto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
    implements ItemListFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemListFragment fragment = ItemListFragment.newInstance("", "");
        fragmentTransaction.add(R.id.main_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
