package com.att.tsa.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.att.tsa.R;
import com.att.tsa.common.BaseActivity;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.root_layout)
    CoordinatorLayout rootLayout;

    private Drawer mNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Tower Safety");

        HomeFragmentPagerAdapter pagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(pagerAdapter.getTabView(i));
            }
        }

        setupNavDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (!mNavDrawer.isDrawerOpen()) {
                    mNavDrawer.openDrawer();
                } else {
                    mNavDrawer.closeDrawer();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavDrawer() {
        mNavDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Home")
                                .withIcon(GoogleMaterial.Icon.gmd_home)
                                .withIdentifier(1)
                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withName("Settings")
                                .withIcon(GoogleMaterial.Icon.gmd_settings)
                                .withIdentifier(2)
                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withName("Help")
                                .withIcon(GoogleMaterial.Icon.gmd_help)
                                .withIdentifier(3)
                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withName("Contact")
                                .withIcon(GoogleMaterial.Icon.gmd_phone)
                                .withIdentifier(4)
                                .withSelectable(false)
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    switch ((int) drawerItem.getIdentifier()) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    return false;
                })
                .build();
    }

    public static void launch(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, HomeActivity.class);
        sourceActivity.startActivity(intent);
    }
}
