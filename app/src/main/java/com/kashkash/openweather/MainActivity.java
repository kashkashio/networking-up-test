package com.kashkash.openweather;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;

import com.kashkash.openweather.util.ActivityHelper;

public class MainActivity extends Activity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityHelper.navigateTo(this, new WeathersFragment(), false, R.id.container_main);
        getFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    public void onBackStackChanged() {

    }


    @Override
    public boolean onNavigateUp() {
        getFragmentManager().popBackStack();
        return true;
    }

}
