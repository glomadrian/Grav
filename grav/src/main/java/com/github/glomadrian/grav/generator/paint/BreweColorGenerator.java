package com.github.glomadrian.grav.generator.paint;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;

public class BreweColorGenerator implements PaintGenerator {
  private OneColorGenerator oneColorGenerator;
  private int counter = 0;
  private String[] colors =
  {"543005", "8C510A", "BF812D", "DFC27D", "F6E8C3", "F5F5F5", "C7EAE5", "80CDC1", "35978F", "01665E", "003C30" };

  public BreweColorGenerator() {
    oneColorGenerator = new OneColorGenerator();
  }

  @Override
  public Paint generate() {
    if (counter >= colors.length) {
      counter = 0;
    }
    String color = colors[counter];
    counter++;
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.parseColor("#"+color));
    return paint;
  }

  @Override
  public void configure(TypedArray attributeSet) {
  }
}
