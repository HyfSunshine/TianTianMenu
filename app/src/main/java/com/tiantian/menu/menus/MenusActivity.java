package com.tiantian.menu.menus;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.tiantian.menu.R;
import com.tiantian.menu.utils.Commons;

public class MenusActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private MenusContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        MenusFragment mf = MenusFragment.newInstance("功效");
        Commons.addFragmentToActivity(getSupportFragmentManager(),mf,R.id.menus_fragment_content);
        presenter = new MenusPresenter(mf);

        final DrawerLayout drawerLayout = findViewById(R.id.menus_drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawer(Gravity.LEFT);

                MenusFragment mf = MenusFragment.newInstance(item.getTitle().toString());
                Commons.replaceFragmentFromActivity(getSupportFragmentManager(),mf,R.id.menus_fragment_content);
                return true;
            }
        });

    }
}
