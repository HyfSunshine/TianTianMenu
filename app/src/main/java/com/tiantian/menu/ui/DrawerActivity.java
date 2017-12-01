package com.tiantian.menu.ui;




import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tiantian.menu.R;
import com.tiantian.menu.minterface.GetMenu_Interface;
import com.tiantian.menu.models.MenuType;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DrawerActivity extends AppCompatActivity {//AppCompatActivity

    private Context mContext;
    DrawerLayout dl;
    private FragmentManager appFm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        dl = findViewById(R.id.dl);
        mContext = this;
        appFm = getSupportFragmentManager();
        initViews();
        request("功效");
    }

    private void request(String menuType) {
        Retrofit rf = new Retrofit.Builder().baseUrl("http://39.108.224.208/CookBook/").addConverterFactory(GsonConverterFactory.create()).build();
        GetMenu_Interface ri = rf.create(GetMenu_Interface.class);
        Call<MenuType> call = ri.getChildByType(menuType);
        call.enqueue(new Callback<MenuType>() {
            @Override
            public void onResponse(Call<MenuType> call, Response<MenuType> response) {
                MenuType type = response.body();
                List<MenuType.DataBean> list = type.getData();
                System.out.println("DrawerActivity连接成功 size = "+list.size());
                Fragment f = new DrawerFragment(list);
                FragmentTransaction ft = appFm.beginTransaction();
                ft.replace(R.id.drawer_content_frame, f);
                ft.commit();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<MenuType> call, Throwable throwable) {
                System.out.println("连接失败"+throwable);
            }
        });

    }

    private void initViews() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //在这里处理item的点击事件
                Toast.makeText(mContext, "item click:" + item.getTitle(), Toast.LENGTH_SHORT).show();
                dl.closeDrawer(Gravity.LEFT);
                request((String) item.getTitle());
                return true;
            }
        });
    }
}
