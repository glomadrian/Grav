package com.github.glomadrian.grav.generator.point;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import java.util.Vector;

public class PercentPointGenerator implements PointGenerator {
  private int[] percentPoints;

  @Override
  public Vector<PointF> generatePoints(int width, int height) {
    if (percentPoints != null && percentPoints.length > 0) {
      return mapToPoints(percentPoints, width, height);
    }
    return new Vector<>(0);
  }

  private float getPercent(int percent, int size) {
    return (size * percent) / 100;
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PercentPointGenerator, 0, 0);
    int reference = attributes.getResourceId(R.styleable.PercentPointGenerator_percent_points_array, 0);
    if (reference != 0) {
      percentPoints = context.getResources().getIntArray(reference);
    }
    attributes.recycle();
  }

  private Vector<PointF> mapToPoints(int[] points, int width, int height) {
    Vector<PointF> vector = new Vector<>();
    for (int i = 0; i < points.length; i += 2) {
      int percentX = points[i];
      int percentY = points[i + 1];
      float x = getPercent(percentX, width);
      float y = getPercent(percentY, height);
      vector.add(new PointF(x, y));
    }
    return vector;
  }
}
