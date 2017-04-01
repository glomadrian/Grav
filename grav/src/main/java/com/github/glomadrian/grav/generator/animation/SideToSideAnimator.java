package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.util.ClassUtil;

public class SideToSideAnimator extends GravAnimatorGenerator<Grav> {
  public static final int VARIANCE = 50;
  private long minAnimationDuration = 2000;
  private long maxAnimationDuration = 3000;
  private Direction direction = Direction.LEFT_TO_RIGHT;
  private Interpolator interpolator;

  @Override
  protected ValueAnimator createValueAnimator(Grav grav, int width, int height) {
    ValueAnimator valueAnimator = createValueAnimatorFor(direction, width, height);
    valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    if (interpolator != null) {
      valueAnimator.setInterpolator(interpolator);
    }
    return valueAnimator;
  }

  private ValueAnimator createValueAnimatorFor(Direction direction, int width, int height) {
    switch (direction) {
      case DOWN_TO_UP:
        return ValueAnimator.ofFloat(height + VARIANCE, 0 - VARIANCE);
      case LEFT_TO_RIGHT:
        return ValueAnimator.ofFloat(0 - VARIANCE, width + VARIANCE);
      case RIGHT_TO_LEFT:
        return ValueAnimator.ofFloat(width + VARIANCE, 0 - VARIANCE);
      case UP_TO_DOWN:
        return ValueAnimator.ofFloat(0 - VARIANCE, height + VARIANCE);
      default:
        return ValueAnimator.ofFloat(0 - VARIANCE, width + VARIANCE);
    }
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
        if (direction.equals(Direction.LEFT_TO_RIGHT) || direction.equals(Direction.RIGHT_TO_LEFT)) {
          grav.setX(value);
        } else {
          grav.setY(value);
        }
      }
    };
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SideToSideAnimator, 0, 0);
    minAnimationDuration =
    attributes.getInteger(R.styleable.SideToSideAnimator_side_to_side_min_duration, (int) minAnimationDuration);
    String interpolatorClassName = attributes.getString(R.styleable.SideToSideAnimator_side_to_side_interpolator);
    if (interpolatorClassName != null) {
      interpolator = ClassUtil.getClassByName(interpolatorClassName, Interpolator.class);
    }
    maxAnimationDuration =
    attributes.getInteger(R.styleable.SideToSideAnimator_side_to_side_max_duration, (int) maxAnimationDuration);
    int directionEnum = attributes.getInteger(R.styleable.SideToSideAnimator_side_to_side_direction, 0);
    switch (directionEnum) {
      case 0:
        direction = Direction.LEFT_TO_RIGHT;
        break;
      case 1:
        direction = Direction.RIGHT_TO_LEFT;
        break;
      case 2:
        direction = Direction.UP_TO_DOWN;
        break;
      case 3:
        direction = Direction.DOWN_TO_UP;
        break;
      default:
        direction = Direction.RIGHT_TO_LEFT;
        break;
    }
    attributes.recycle();
  }

  private enum Direction {
    LEFT_TO_RIGHT, RIGHT_TO_LEFT, UP_TO_DOWN, DOWN_TO_UP
  }
}
