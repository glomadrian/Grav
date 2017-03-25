package com.github.glomadrian.grav.generator.paint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.glomadrian.grav.R;

public class OneColorGenerator implements PaintGenerator {
  private int color = Color.parseColor("#85FFFFFF");

  @Override
  public Paint generate() {
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(color);
    return paint;
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    color = attributeSet.getColor(R.styleable.GravView_grav_color, color);
  }
}
