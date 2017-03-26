package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;

public class AlphaAnimator extends GravAnimatorGenerator<Grav> {
  private int from = 0;
  private int to = 255;
  private int minAnimationDuration = 1000;
  private int maxAnimationDuration = 3000;

  @Override
  protected ValueAnimator createValueAnimator(Grav grav, int width, int height) {
    ValueAnimator valueAnimator = ValueAnimator.ofInt(from, to);
    valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
    return valueAnimator;
  }

  private long getRandomDuration(long min, long max){
    return min + (int)(Math.random() * max);
  }

  @Override
  protected UpdageGravListener<Grav> createUpdateListener() {
    return new UpdageGravListener<Grav>() {
      @Override
      public void onUpdate(Grav grav, ValueAnimator animator) {
        int alpha = (int) animator.getAnimatedValue();
        grav.getPaint().setAlpha(alpha);
      }
    };
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AlphaAnimator, 0, 0);
    from = attributes.getInteger(R.styleable.AlphaAnimator_alpha_from, from);
    to = attributes.getInteger(R.styleable.AlphaAnimator_alpha_to, to);
    minAnimationDuration = attributes.getInteger(R.styleable.AlphaAnimator_alpha_min_duration, minAnimationDuration);
    maxAnimationDuration = attributes.getInteger(R.styleable.AlphaAnimator_alpha_max_duration, maxAnimationDuration);
    attributes.recycle();
  }
}
