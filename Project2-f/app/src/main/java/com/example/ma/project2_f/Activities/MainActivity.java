
package com.example.ma.project2_f.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ma.project2_f.Adapters.MyFragmentPagerAdapter;
import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Fragments.Fragment1;
import com.example.ma.project2_f.Fragments.Fragment2;
import com.example.ma.project2_f.Fragments.Fragment3;
import com.example.ma.project2_f.Fragments.Fragment4;
import com.example.ma.project2_f.Fragments.Help;
import com.example.ma.project2_f.Fragments.Home;
import com.example.ma.project2_f.Fragments.SearchFrag;
import com.example.ma.project2_f.Fragments.Setting;
import com.example.ma.project2_f.Other_Classes.Fragment_Adapter_items;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Context cc=this;
    NavigationView nav_menu;
    Fragment SlideFrag;
    boolean test=true;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&&test){
            finish();
            startActivity(getIntent());
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        LargeText();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tablis();
        SlideMenu();
    }



    private void LargeText() {

        if(IsTxtLarg.isLarg())
            setTheme(R.style.LargText);
        else  setTheme(R.style.NormalText);
    }

    private void SlideMenu() {
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        nav_menu=(NavigationView)findViewById(R.id.nav_menu);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        nav_menu.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void tablis(){
        SlideFrag=new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen_layout,SlideFrag).commit();
        test=false;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        else if(item.getItemId()==R.id.search){

            SlideFrag=new SearchFrag();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen_layout,SlideFrag).commit();
            test=true;
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.home){
            finish();
            startActivity(getIntent());
            test=false;
        }
        else if(id==R.id.setting){
            SlideFrag=new Setting();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen_layout,SlideFrag).commit();
            test=true;
        }
        else if(id==R.id.help){
            SlideFrag=new Help();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen_layout,SlideFrag).commit();
            test=true;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}