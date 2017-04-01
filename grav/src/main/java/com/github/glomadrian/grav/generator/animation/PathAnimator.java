package com.github.glomadrian.grav.generator.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.generator.animation.path.ConstrainedSvgPathParser;
import com.github.glomadrian.grav.generator.animation.path.SvgPathParser;
import java.text.ParseException;

public class PathAnimator extends GravAnimatorGenerator<Grav> {
  private Path path;
  private float minVariance = 0;
  private float maxVariance = 100;
  private String pathString = "";
  private int originalPathWidth;
  private int originalPathHeight;
  private int minAnimationDuration = 2000;
  private int maxAnimationDuration = 5000;

  @Override
  protected ValueAnimator createValueAnimator(Grav grav, int width, int height) {
    ValueAnimator valueAnimator = new ValueAnimator();
    try {
      generatePath(width, height);
      valueAnimator.setRepeatMode(ValueAnimator.RESTART);
      valueAnimator.setInterpolator(new LinearInterpolator());
      valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
      valueAnimator.setDuration(getRandomDuration(minAnimationDuration, maxAnimationDuration));
      valueAnimator.setFloatValues(0f, 1f);
    } catch(ParseException e) {
      Log.e(getClass().getName(), "PathAnimator: ", e);
    }
    return valueAnimator;
  }

  private long getRandomDuration(long min, long max){
    return min + (int)(Math.random() * max);
  }

  private long getRandomVariance(float min, float max){
    return (long) (min + (Math.random() * max));
  }

  private float[] getPathCoordinates(Path path, float fraction) {
    float aCoordinates[] = { 0f, 0f };
    PathMeasure pm = new PathMeasure(path, false);
    pm.getPosTan(pm.getLength() * fraction, aCoordinates, null);
    return aCoordinates;
  }

  private Path generatePath(int width, int height) throws ParseException {
    SvgPathParser svgPathParser =
    new ConstrainedSvgPathParser.Builder().originalWidth(originalPathWidth)
    .originalHeight(originalPathHeight)
    .viewWidth(width)
    .viewHeight(height)
    .build();
    path = svgPathParser.parsePath(pathString);
    return path;
  }

  @Override
  protected UpdageGravListener<Grav> createUpdateListener() {
    return new PathUpdateGravListener(getRandomVariance(minVariance, maxVariance));
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PathAnimator, 0, 0);
    minVariance = attributes.getDimension(R.styleable.PathAnimator_path_variance_from, minVariance);
    maxVariance = attributes.getDimension(R.styleable.PathAnimator_path_variance_to, maxVariance);
    pathString = attributes.getString(R.styleable.PathAnimator_path);
    originalPathWidth = attributes.getInteger(R.styleable.PathAnimator_path_original_width, 0);
    originalPathHeight = attributes.getInteger(R.styleable.PathAnimator_path_original_height, 0);
    minAnimationDuration = attributes.getInteger(R.styleable.PathAnimator_path_min_duration, minAnimationDuration);
    maxAnimationDuration = attributes.getInteger(R.styleable.PathAnimator_path_max_duration, maxAnimationDuration);
    attributes.recycle();
  }

  private class PathUpdateGravListener implements UpdageGravListener<Grav> {
    private float variance;

    public PathUpdateGravListener(float variance) {
      this.variance = variance;
    }

    @Override
    public void onUpdate(Grav grav, ValueAnimator animator) {
      float value = animator.getAnimatedFraction();
      float[] coordinates = getPathCoordinates(path, value);
      grav.setX(coordinates[0] + variance);
      grav.setY(coordinates[1] + variance);
    }
  }
}
