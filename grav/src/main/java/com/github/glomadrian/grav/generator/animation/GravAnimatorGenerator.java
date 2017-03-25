package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import com.github.glomadrian.grav.figures.Grav;

public abstract class GravAnimatorGenerator<T extends Grav> {

  public ValueAnimator generateGravAnimator(T grav){
    ValueAnimator valueAnimator =  createValueAnimator(grav);
    UpdageGravListener<T> updageGravListenerListener = createUpdateListener();
    valueAnimator.addUpdateListener(new AnimatorUpdateListener(grav, updageGravListenerListener));
    return valueAnimator;
  }

  protected abstract ValueAnimator createValueAnimator(T grav);
  protected abstract UpdageGravListener<T> createUpdateListener();
  public abstract void configure(TypedArray attributeSet, Context context);

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

  public interface UpdageGravListener<T> {
      void onUpdate(T grav, ValueAnimator animator);
  }
}
