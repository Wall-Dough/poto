package com.wall_dough.poto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.wall_dough.poto.models.items.lists.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int RC_SIGN_IN = 2342;

    private NavigationView mNavDrawer;
    private DrawerLayout mDrawerLayout;
    private static MainActivity mCurrentInstance;


    public static MainActivity getInstance() {
        return mCurrentInstance;
    }

    public static Context getContext() {
        return mCurrentInstance.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentInstance = this;

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

        initFragment(ItemListFragment.Category.FESTIVALS);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavDrawer = (NavigationView) findViewById(R.id.navView);
        setupDrawerContent(mNavDrawer);
    }

    private void initFragment(String category) {
        if (!isFinishing()) {
            FragmentManager fragmentManager = getFragmentManager();

            int count = fragmentManager.getBackStackEntryCount();
            for (int i = 0; i < count; i++) {
                fragmentManager.popBackStack();
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ItemListFragment fragment = ItemListFragment.newInstance(category);
            fragmentTransaction.replace(R.id.main_layout, fragment);
            fragmentTransaction.commit();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
            case R.id.nav_festivals:
                initFragment(ItemListFragment.Category.FESTIVALS);
                break;
            case R.id.nav_vendors:
                initFragment(ItemListFragment.Category.VENDORS);
                break;
            case R.id.nav_food:
                initFragment(ItemListFragment.Category.FOOD);
                break;
            case R.id.nav_drinks:
                initFragment(ItemListFragment.Category.DRINKS);
                break;
            case R.id.nav_signout:
                break;
            default:
        }

        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();
    }
}
