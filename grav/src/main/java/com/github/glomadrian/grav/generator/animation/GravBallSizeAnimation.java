package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.figures.GravBall;

public class GravBallSizeAnimation extends GravAnimatorGenerator<GravBall> {
  private long minAnimationDuration = 2000;
  private long maxAnimationDuration = 3000;
  private int fromSize = 0;
  private int toSize = 40;

  @Override
  protected ValueAnimator createValueAnimator(GravBall grav, int width, int height) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(fromSize , toSize);
    valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
    return valueAnimator;
  }

  private long getRandomDuration(long min, long max){
    return min + (int)(Math.random() * max);
  }

  @Override
  protected UpdageGravListener<GravBall> createUpdateListener() {
    return new UpdageGravListener<GravBall>() {
      @Override
      public void onUpdate(GravBall grav, ValueAnimator animator) {
        float value = (float) animator.getAnimatedValue();
        grav.setRadius((int) value);
      }
    };
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    minAnimationDuration = attributeSet.getInteger(R.styleable.GravView_min_animation_time, (int) minAnimationDuration);
    maxAnimationDuration = attributeSet.getInteger(R.styleable.GravView_max_animation_time, (int) maxAnimationDuration);
    fromSize = attributeSet.getInteger(R.styleable.GravView_grav_ball_size_anim_from_size, fromSize);
    toSize = attributeSet.getInteger(R.styleable.GravView_grav_ball_size_anim_to_size, toSize);
  }
}
