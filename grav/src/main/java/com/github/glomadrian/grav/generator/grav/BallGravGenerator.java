package com.github.glomadrian.grav.generator.grav;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.GravBall;
import com.github.glomadrian.grav.figures.Grav;

public class BallGravGenerator implements GravGenerator {
  private float radius = 90;

  @Override
  public Grav generate(PointF startPoint, Paint paint) {
    return new GravBall(startPoint, paint, (int) radius);
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    radius = attributeSet.getDimension(R.styleable.GravView_size, radius);
  }
}
