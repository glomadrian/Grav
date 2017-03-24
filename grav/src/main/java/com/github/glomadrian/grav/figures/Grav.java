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

  public void animate(){

  }

  public void setDrawPoint(PointF point){
    this.drawPoint = point;
  }

  public PointF getDrawPoint() {
    return drawPoint;
  }

  public PointF getStartPoint() {
    return startPoint;
  }
}
