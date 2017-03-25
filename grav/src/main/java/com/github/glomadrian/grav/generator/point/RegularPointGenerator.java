package com.github.glomadrian.grav.generator.point;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import com.github.glomadrian.grav.R;
import java.util.Random;
import java.util.Vector;

/**
 * Regular point generator
 *
 * @author manolovn
 */
public class RegularPointGenerator implements PointGenerator {
  private final Random random = new Random();
  private int cellSize = 300;
  private int variance = 5;

  @Override
  public Vector<PointF> generatePoints(int width, int height) {
    Vector<PointF> points = new Vector<>();
    for (int j = 0; j < height ; j += cellSize) {
      for (int i = 0; i < width ; i += cellSize) {
        int x = i + random.nextInt(variance);
        int y = j + random.nextInt(variance);
        points.add(new PointF(x, y));
      }
    }
    return points;
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    cellSize = attributeSet.getColor(R.styleable.GravView_cell_size, cellSize);
    variance = attributeSet.getColor(R.styleable.GravView_variance, variance);
  }
}