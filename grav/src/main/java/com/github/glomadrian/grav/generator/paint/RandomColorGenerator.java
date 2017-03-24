package com.github.glomadrian.grav.generator.paint;

import android.content.res.TypedArray;
import android.graphics.Paint;
import java.util.Random;

public class RandomColorGenerator implements PaintGenerator {
  private Random random = new Random();

  @Override
  public Paint generate() {
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setARGB(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    return paint;
  }

  @Override
  public void configure(TypedArray attributeSet) {
  }
}
