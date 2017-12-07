package com.tiantian.menu.views;




import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tiantian.menu.R;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.presenters.IDrawerPresenter;
import com.tiantian.menu.presenters.DrawerPresenterImpl;

public class DrawerActivity extends AppCompatActivity implements IDrawerView {//AppCompatActivity


    private DrawerLayout drawerLayout;
    private IDrawerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout = findViewById(R.id.dl);
        initViews();
        presenter = new DrawerPresenterImpl(this);
        presenter.getMenuTypes("功效");

    }

    private void initViews() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                hiddenDrawer();
                presenter.getMenuTypes((String) item.getTitle());
                return true;
            }
        });
    }

    @Override
    public void showDrawer() {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    public void hiddenDrawer() {
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void replaceFragment(MenuType menuType) {
        Fragment f = DrawerFragment.newInstance(menuType.getData());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.drawer_content_frame, f);
        ft.commit();
    }

    @Override
    public void requestError() {
        Toast.makeText(this,"网络请求失败，请您稍后再试",Toast.LENGTH_SHORT).show();
    }
}
