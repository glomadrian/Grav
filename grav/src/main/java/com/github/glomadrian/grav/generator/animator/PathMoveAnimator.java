package com.github.glomadrian.grav.generator.animator;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.github.glomadrian.grav.figures.Grav;

public class PathMoveAnimator extends GravAnimatorGenerator<Grav> {

  @Override
  protected ValueAnimator createValueAnimator(Grav grav) {
    PointF startPoint = grav.getStartPoint();
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(startPoint.x - 50, startPoint.x + 50);
    valueAnimator.setDuration(getRandomDuration(2000, 3000));
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
        float value = (float) animator.getAnimatedValue();
        PointF drawPoint = new PointF();
        drawPoint.x = value;
        drawPoint.y = grav.getStartPoint().y;
        grav.setDrawPoint(drawPoint);
      }
    };
  }
}
