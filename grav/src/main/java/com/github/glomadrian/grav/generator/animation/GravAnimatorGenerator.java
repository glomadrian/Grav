package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import com.github.glomadrian.grav.figures.Grav;

public abstract class GravAnimatorGenerator<T extends Grav> {

  public ValueAnimator generateGravAnimator(T grav, int width, int height) {
    ValueAnimator valueAnimator = createValueAnimator(grav, width, height);
    UpdageGravListener<T> updageGravListenerListener = createUpdateListener();
    valueAnimator.addUpdateListener(new AnimatorUpdateListener(grav, updageGravListenerListener));
    return valueAnimator;
  }

  protected abstract ValueAnimator createValueAnimator(T grav, int width, int height);

  protected abstract UpdageGravListener<T> createUpdateListener();

  public abstract void configure(AttributeSet attributeSet, Context context);

  public interface UpdageGravListener<T> {
    void onUpdate(T grav, ValueAnimator animator);
  }

  private class AnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final T grav;
    private final UpdageGravListener UpdageGravListener;

    private AnimatorUpdateListener(T grav, UpdageGravListener UpdageGravListener) {
      this.grav = grav;
      this.UpdageGravListener = UpdageGravListener;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
      UpdageGravListener.onUpdate(grav, animation);
    }
  }
}
