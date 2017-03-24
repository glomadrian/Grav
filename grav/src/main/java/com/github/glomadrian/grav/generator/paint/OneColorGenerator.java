package com.github.glomadrian.grav.generator.paint;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;

public class OneColorGenerator implements PaintGenerator {
  @Override
  public Paint generate() {
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.parseColor("#85FFFFFF"));
    return paint;
  }

  @Override
  public void configure(TypedArray attributeSet) {
  }
}
