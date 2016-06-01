package com.wall_dough.poto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.wall_dough.poto.models.items.lists.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isFinishing()) {
            FragmentManager fragmentManager = getFragmentManager();

            int count = fragmentManager.getBackStackEntryCount();
            for (int i = 0; i < count; i++) {
                fragmentManager.popBackStack();
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ItemListFragment fragment = ItemListFragment.newInstance("", "");
            fragmentTransaction.replace(R.id.main_layout, fragment);
            fragmentTransaction.commit();
        }
    }
}
