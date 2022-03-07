package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);
            switch (id){
                case R.id.nav_home:
                    Toast.makeText(MainActivity.this, "home is clicked!!", Toast.LENGTH_SHORT).show();
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.nav_message:
                    Toast.makeText(MainActivity.this, "message is clicked!!", Toast.LENGTH_SHORT).show();
                    replaceFragment(new MessageFragment());
                    break;
                case R.id.nav_settings:
                    Toast.makeText(MainActivity.this, "settings is clicked!!", Toast.LENGTH_SHORT).show();
                    replaceFragment(new SettingsFragment());
                    break;
                case R.id.nav_trash:
                    Toast.makeText(MainActivity.this, "delete is clicked!!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_login:
                    Toast.makeText(MainActivity.this, "login is clicked!!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_rate:
                    Toast.makeText(MainActivity.this, "rate is clicked!!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_sync:
                    Toast.makeText(MainActivity.this, "sync is clicked!!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_share_:
                    Toast.makeText(MainActivity.this, "share is clicked!!", Toast.LENGTH_SHORT).show();
                    break;
                default: return true;
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}