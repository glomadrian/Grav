package com.github.glomadrian.grav.figures;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class GravBall extends Grav{
  private int radius;

  public GravBall(PointF startPoint, Paint paint,  int radius) {
    super(startPoint, paint);
    this.radius = radius;
  }

  public void draw(Canvas canvas, PointF drawPoint){
    canvas.drawCircle(drawPoint.x, drawPoint.y, radius, paint);
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }
}
