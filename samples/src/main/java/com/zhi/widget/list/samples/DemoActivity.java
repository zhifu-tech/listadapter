package com.zhi.widget.list.samples;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zhi.volley.ZhiVolley;
import com.zhi.volley.uti.Logs;

public class DemoActivity extends BaseActivity implements OnNavigationItemSelectedListener, View.OnClickListener {
    public static final String TAG = Logs.makeLogTag("DemoActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ZhiVolley.getInstance().init(this);

        final Toolbar toolbar = findView(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findView(R.id.fab);
        fab.setOnClickListener(this);

        final DrawerLayout drawer = findView(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = findView(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findView(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Fragment mCurrentFragment;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        final FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_simple) {
            // display simple list adapter.
            ZhiSimpleListFragment f = findFragment(ZhiSimpleListFragment.TAG);
            if (f == null) {
                f = ZhiSimpleListFragment.newInstance();
                ft.add(R.id.container, f, ZhiSimpleListFragment.TAG);
                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.commit();

            } else if (f.isHidden()) {
                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.show(f).commit();

            } else if (f == mCurrentFragment) {
                Logs.d(TAG, "fragment %s maybe shown", mCurrentFragment);
            } else {
                ft.remove(f).commit();

                ft = fm.beginTransaction();
                ft.add(R.id.container, f, ZhiSimpleListFragment.TAG);

                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.commit();
            }
            mCurrentFragment = f;

        } else if (id == R.id.nav_complex) {
            ZhiComplexListFragment f = findFragment(ZhiComplexListFragment.TAG);
            if (f == null) {
                f = ZhiComplexListFragment.newInstance();
                ft.add(R.id.container, f, ZhiComplexListFragment.TAG);
                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.commit();

            } else if (f.isHidden()) {
                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.show(f).commit();
            } else if (f == mCurrentFragment) {
                Logs.d(TAG, "fragment %s maybe shown", mCurrentFragment);
            } else {
                ft.remove(f).commit();

                ft = fm.beginTransaction();
                ft.add(R.id.container, f, ZhiComplexListFragment.TAG);

                if (mCurrentFragment != null && !mCurrentFragment.isHidden()) {
                    ft.hide(mCurrentFragment);
                }
                ft.commit();
            }
            mCurrentFragment = f;

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
