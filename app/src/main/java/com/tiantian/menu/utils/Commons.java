package com.tiantian.menu.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class Commons {

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int layoutID){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layoutID, fragment);
        transaction.commit();
    }

    public static void replaceFragmentFromActivity(FragmentManager fragmentManager, Fragment fragment, int layoutID){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(layoutID, fragment);
        transaction.commit();
    }
}
