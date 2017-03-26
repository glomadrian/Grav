package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.figures.GravBall;

public class BallSizeAnimator extends GravAnimatorGenerator<GravBall> {
  private long minAnimationDuration = 2000;
  private long maxAnimationDuration = 3000;
  private float fromSize = 0;
  private float toSize = 40;

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
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BallSizeAnimator, 0, 0);
    minAnimationDuration = typedArray.getInteger(R.styleable.BallSizeAnimator_ball_size_min_duration, (int) minAnimationDuration);
    maxAnimationDuration = typedArray.getInteger(R.styleable.BallSizeAnimator_ball_size_max_duration, (int) maxAnimationDuration);
    fromSize = typedArray.getDimension(R.styleable.BallSizeAnimator_ball_size_from_size, fromSize);
    toSize = typedArray.getDimension(R.styleable.BallSizeAnimator_ball_size_to_size, toSize);
    typedArray.recycle();
  }
}
