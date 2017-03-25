package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;

public class ShakeAnimator extends GravAnimatorGenerator<Grav> {
  private float variance = 50;
  private long minAnimationDuration = 2000;
  private long maxAnimationDuration = 3000;
  private Direction direction = Direction.HORIZONTAL;

  @Override
  protected ValueAnimator createValueAnimator(Grav grav, int width, int height) {
    PointF startPoint = grav.getStartPoint();
    ValueAnimator valueAnimator = createValueAnimatorFor(direction, startPoint);
    valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
    return valueAnimator;
  }

  private ValueAnimator createValueAnimatorFor(Direction direction, PointF startPoint) {
    if (direction.equals(Direction.HORIZONTAL)){
      return ValueAnimator.ofFloat(startPoint.x - variance, startPoint.x + variance);
    } else {
      return ValueAnimator.ofFloat(startPoint.y - variance, startPoint.y + variance);
    }
  }

  private long getRandomDuration(long min, long max){
    return min + (int)(Math.random() * max);
  }

  @Override
  protected UpdageGravListener<Grav> createUpdateListener() {
    return new UpdageGravListener<Grav>() {
      @Override
      public void onUpdate(Grav grav, ValueAnimator animator) {
        float value = (float) animator.getAnimatedValue();
        if (direction.equals(Direction.HORIZONTAL)) {
          grav.setX(value);
        } else {
          grav.setY(value);
        }
      }
    };
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    variance = attributeSet.getDimension(R.styleable.GravView_animation_variance, variance);
    minAnimationDuration = attributeSet.getInteger(R.styleable.GravView_min_animation_time, (int) minAnimationDuration);
    maxAnimationDuration = attributeSet.getInteger(R.styleable.GravView_max_animation_time, (int) maxAnimationDuration);
    int directionEnum = attributeSet.getInteger(R.styleable.GravView_shake_direction, 0);
    if (directionEnum == 0){
      direction = Direction.HORIZONTAL;
    } else {
      direction = Direction.VERTICAL;
    }
  }

  private enum Direction{
    HORIZONTAL, VERTICAL
  }
}
