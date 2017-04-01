package com.github.glomadrian.grav.figures;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class GravRectangle extends Grav {
  private final float width;
  private final float height;

  public GravRectangle(PointF startPoint, Paint paint, float width, float height) {
    super(startPoint, paint);
    this.width = width;
    this.height = height;
  }

  @Override
  protected void draw(Canvas canvas, PointF drawPoint) {
    float stopX = drawPoint.x + width;
    float stopY = drawPoint.y + height;
    canvas.drawRect(drawPoint.x, drawPoint.y, stopX, stopY, paint);
  }
}
