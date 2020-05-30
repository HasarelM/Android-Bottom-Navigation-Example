package com.sample.hasarel.bottomnavigation.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sample.hasarel.bottomnavigation.Fragment.Fragment1;
import com.sample.hasarel.bottomnavigation.Fragment.Fragment2;
import com.sample.hasarel.bottomnavigation.Fragment.Fragment3;
import com.sample.hasarel.bottomnavigation.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = Fragment1.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = Fragment2.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = Fragment3.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Fragment1.newInstance());
        transaction.commit();
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.navigation);
    }
}
