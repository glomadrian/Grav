package com.github.glomadrian.grav.figures;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public abstract class Grav {
  protected final Paint paint;
  protected final PointF startPoint;
  protected PointF drawPoint;

  public Grav(PointF startPoint, Paint paint) {
    this.startPoint = startPoint;
    this.paint = paint;
    drawPoint = new PointF(startPoint.x, startPoint.y);
  }

  public void draw(Canvas canvas) {
    draw(canvas, drawPoint);
  }

  protected abstract void draw(Canvas canvas, PointF drawPoint);

  public void setX(float x) {
    drawPoint.x = x;
  }

  public void setY(float y) {
    drawPoint.y = y;
  }

  public float getX(){
    return drawPoint.x;
  }

  public float getY() {
    return drawPoint.y;
  }

  public PointF getDrawPoint() {
    return drawPoint;
  }

  public void setDrawPoint(PointF point) {
    this.drawPoint = point;
  }

  public PointF getStartPoint() {
    return startPoint;
  }

  public Paint getPaint() {
    return paint;
  }
}
