package com.wall_dough.poto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.wall_dough.poto.models.items.lists.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int RC_SIGN_IN = 2342;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // already signed in
        } else {
            // not signed in
            startActivityForResult(
                    AuthUI.getInstance(FirebaseApp.getInstance())
                            .createSignInIntentBuilder()
                            .setProviders(
                                    AuthUI.EMAIL_PROVIDER)
                            .build(),
                    RC_SIGN_IN);
        }

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
