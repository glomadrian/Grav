package com.github.glomadrian.grav.generator.point;

import android.graphics.PointF;
import java.util.Random;
import java.util.Vector;

/**
 * Regular point generator
 *
 * @author manolovn
 */
public class RegularPointGenerator implements PointGenerator {
  private final Random random = new Random();
  private int bleedX = 0;
  private int bleedY = 0;

  @Override
  public void setBleedX(int bleedX) {
    this.bleedX = bleedX;
  }

  @Override
  public void setBleedY(int bleedY) {
    this.bleedY = bleedY;
  }

  @Override
  public Vector<PointF> generatePoints(int width, int height, int cellSize, int variance) {
    Vector<PointF> points = new Vector<>();
    for (int j = -bleedY; j < height + bleedY; j += cellSize) {
      for (int i = -bleedX; i < width + bleedX; i += cellSize) {
        int x = i + random.nextInt(variance);
        int y = j + random.nextInt(variance);
        points.add(new PointF(x, y));
      }
    }
    return points;
  }
}