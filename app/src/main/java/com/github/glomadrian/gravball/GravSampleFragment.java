package com.github.glomadrian.gravball;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.glomadrian.grav.GravView;

public class GravSampleFragment extends Fragment {
  public static final String KEY_LAYOUT = "KEY_LAYOUT";
  private int layout;
  @BindView(R.id.grav) GravView gravView;

  public static GravSampleFragment newInstance(int layout) {
    Bundle args = new Bundle();
    args.putInt(KEY_LAYOUT, layout);
    GravSampleFragment fragment = new GravSampleFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    layout = getArguments().getInt(KEY_LAYOUT);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }

  @Override
  public void onPause() {
    super.onPause();
    gravView.stop();
  }
}
