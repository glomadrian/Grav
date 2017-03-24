package com.github.glomadrian.grav.generator.grav;

import android.graphics.Paint;
import android.graphics.PointF;
import com.github.glomadrian.grav.figures.Ball;
import com.github.glomadrian.grav.figures.Grav;

public class BallGravGenerator implements GravGenerator {
  private final int DEFAULT_RADIUS = 90;

  @Override
  public Grav generate(PointF startPoint, Paint paint) {
    return new Ball(startPoint, paint, DEFAULT_RADIUS);
  }
}
