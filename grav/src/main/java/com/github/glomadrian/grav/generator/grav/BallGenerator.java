package com.github.glomadrian.grav.generator.grav;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.GravBall;
import com.github.glomadrian.grav.figures.Grav;

public class BallGenerator implements GravGenerator {
  private float radius = 90;

  @Override
  public Grav generate(PointF startPoint, Paint paint) {
    return new GravBall(startPoint, paint, (int) radius);
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BallGenerator, 0, 0);
    radius = attributes.getDimension(R.styleable.BallGenerator_ball_size, radius);
    attributes.recycle();
  }
}
