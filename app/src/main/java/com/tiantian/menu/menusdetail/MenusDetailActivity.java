package com.tiantian.menu.menusdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tiantian.menu.R;

public class MenusDetailActivity extends AppCompatActivity {

    
    public static void start(Context context, int id) {

        Intent starter = new Intent(context, MenusDetailActivity.class);
        starter.putExtra("id",id);
        context.startActivity(starter);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_detail);
    }
}
