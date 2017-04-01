package com.github.glomadrian.gravball;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.drawer) DrawerLayout drawerLayout;
  @BindView(R.id.nav) NavigationView navigationView;
  private ActionBarDrawerToggle actionBarDrawerToggle;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    showView(R.layout.grav);
    setSupportActionBar(toolbar);
    actionBarDrawerToggle =
    new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
                             R.string.app_name);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    actionBarDrawerToggle.syncState();
    initNavigationView();
  }

   private void showView(@LayoutRes int view){
    getSupportFragmentManager().beginTransaction().replace(R.id.container, GravSampleFragment.newInstance(view))
    .commit();
  }

  private void initNavigationView() {
    navigationView.setNavigationItemSelectedListener(
    new NavigationView.OnNavigationItemSelectedListener() {
      @Override public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
          case R.id.ball_wave:
            showView(R.layout.ball_wave);
            return true;
          case R.id.grav:
            showView(R.layout.grav);
            return true;
          case R.id.robot:
            showView(R.layout.robot);
            return true;
          case R.id.falcon:
            showView(R.layout.falcon);
            return true;
          case R.id.bubble:
            showView(R.layout.bubble);
            return true;
          case R.id.path:
            showView(R.layout.path);
            return true;
        }
        return false;
      }
    });
  }
}
