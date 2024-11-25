package vn.nguyenbuiquanghuy.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vn.nguyenbuiquanghuy.android_project.Account.Login;
import vn.nguyenbuiquanghuy.android_project.Fragment.HomeFragment;
import vn.nguyenbuiquanghuy.android_project.Fragment.NewFragment;
import vn.nguyenbuiquanghuy.android_project.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            Intent intent= getIntent();
            String userName = intent.getStringExtra("name");
            // Chuyển qua HomeFragment và truyền tên người dùng
            HomeFragment homeFragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name",userName); // Thêm tên người dùng vào Bundle
            // Truyền Bundle vào HomeFragment
            homeFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, homeFragment).commit();
        } else if (item.getItemId() == R.id.nav_follow) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new NewFragment()).commit();
        } else if (item.getItemId() == R.id.nav_profile) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new ProfileFragment()).commit();
        } else if (item.getItemId() == R.id.nav_logout) {
            startActivity(new Intent(MainActivity.this, Login.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_nav,menu);
        return true;
    }
}