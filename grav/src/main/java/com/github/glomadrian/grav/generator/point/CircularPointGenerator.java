package com.github.glomadrian.grav.generator.point;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import java.util.Random;
import java.util.Vector;

/**
 * Circular point generator
 *
 * @author manolovn
 */
public class CircularPointGenerator implements PointGenerator {
  private final static int POINTS_PER_CIRCLE = 8;
  private final Random random = new Random();
  private int cellSize = 300;
  private int variance = 5;

  @Override
  public Vector<PointF> generatePoints(int width, int height) {
    Vector<PointF> points = new Vector<>();
    PointF center = new PointF(width / 2, height / 2);
    points.add(new PointF(center.x, center.y));
    int limit = Math.max(width, height);
    for (int radius = cellSize; radius < limit; radius += cellSize) {
      double slice = 2 * Math.PI / POINTS_PER_CIRCLE;
      for (int i = 0; i < POINTS_PER_CIRCLE; i++) {
        double angle = slice * i;
        int x = (int) (center.x + radius * Math.cos(angle)) + random.nextInt(variance);
        int y = (int) (center.y + radius * Math.sin(angle)) + random.nextInt(variance);
        points.add(new PointF(x, y));
      }
    }
    return points;
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircularPointGenerator, 0, 0);
    cellSize = attributes.getInteger(R.styleable.CircularPointGenerator_circular_cell_size, cellSize);
    variance = attributes.getInteger(R.styleable.CircularPointGenerator_circular_variance, variance);
    attributes.recycle();
  }
}