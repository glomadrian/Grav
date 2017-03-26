package com.github.glomadrian.gravball;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    showView(R.layout.home);
  }

   private void showView(@LayoutRes int view){
    getSupportFragmentManager().beginTransaction().replace(R.id.container, GravSampleFragment.newInstance(view))
    .commit();
  }

  @OnClick(R.id.ball_wave)
  public void ballWaveClick(){
    showView(R.layout.ball_wave);
  }


  @OnClick(R.id.home)
  public void homeClick(){
    showView(R.layout.home);
  }

  @OnClick(R.id.kamehameha)
  public void falconClick(){
    showView(R.layout.falcon);
  }

  @OnClick(R.id.bubble)
  public void bubbleClick(){
    showView(R.layout.bubble);
  }
}
