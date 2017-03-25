package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;

public class DownToUpAnimator extends GravAnimatorGenerator<Grav> {
  private long minAnimationDuration = 2000;
  private long maxAnimationDuration = 3000;

  @Override
  protected ValueAnimator createValueAnimator(Grav grav, int width, int height) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat( height + 50, 0 - 50);
    valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    return valueAnimator;
  }

  private long getRandomDuration(long min, long max) {
    return min + (int) (Math.random() * max);
  }

  @Override
  protected GravAnimatorGenerator.UpdageGravListener<Grav> createUpdateListener() {
    return new GravAnimatorGenerator.UpdageGravListener<Grav>() {
      @Override
      public void onUpdate(Grav grav, ValueAnimator animator) {
        float value = (float) animator.getAnimatedValue();
        grav.setY(value);
      }
    };
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    minAnimationDuration =
    attributeSet.getInteger(R.styleable.GravView_down_to_up_min_animation_time, (int) minAnimationDuration);
    maxAnimationDuration =
    attributeSet.getInteger(R.styleable.GravView_down_to_up_max_animation_time, (int) maxAnimationDuration);
  }
}
