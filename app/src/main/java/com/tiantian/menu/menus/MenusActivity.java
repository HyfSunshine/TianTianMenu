package com.tiantian.menu.menus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;

import com.tiantian.menu.R;
import com.tiantian.menu.base.BaseActivity;
import com.tiantian.menu.utils.Commons;

public class MenusActivity extends BaseActivity {
    private  MenusFragment mf;
    private MenusContract.Presenter presenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MenusActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menus);

        mf = MenusFragment.newInstance("功效");

        Commons.addFragmentToActivity(getSupportFragmentManager(),mf,R.id.menus_fragment_content);
        presenter = new MenusPresenter(mf);

        final DrawerLayout drawerLayout = findViewById(R.id.menus_drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                //mf.onDrawerChange(item.getTitle().toString());
                presenter.getMenusByType(item.getTitle().toString());
                return true;
            }
        });

    }
}
