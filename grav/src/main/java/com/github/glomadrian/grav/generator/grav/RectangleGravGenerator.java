
package com.github.glomadrian.grav.generator.grav;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.figures.GravBall;
import com.github.glomadrian.grav.figures.GravRectangle;

public class RectangleGravGenerator implements GravGenerator {
  private float width = 40;
  private float height = 40;

  @Override
  public Grav generate(PointF startPoint, Paint paint) {
    return new GravRectangle(startPoint, paint, width, height);
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    width = attributeSet.getDimension(R.styleable.GravView_width, width);
    height = attributeSet.getDimension(R.styleable.GravView_height, height);
  }
}
