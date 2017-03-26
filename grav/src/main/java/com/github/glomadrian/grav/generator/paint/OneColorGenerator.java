package com.github.glomadrian.grav.generator.paint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SingleColorGenerator, 0, 0);
    color = attributes.getColor(R.styleable.SingleColorGenerator_single_color, color);
    attributes.recycle();
  }
}
