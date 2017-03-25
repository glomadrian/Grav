package com.github.glomadrian.grav.generator.paint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.glomadrian.grav.R;

public class ArrayColorGenerator implements PaintGenerator {
  private int counter = 0;
  private String[] colors =
  { "#543005", "#8C510A", "#BF812D", "#DFC27D", "#F6E8C3", "#F5F5F5", "#C7EAE5", "#80CDC1", "#35978F", "#01665E", "#003C30" };

  @Override
  public Paint generate() {
    if (counter >= colors.length) {
      counter = 0;
    }
    String color = colors[counter];
    counter++;
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.parseColor(color));
    return paint;
  }

  @Override
  public void configure(TypedArray attributeSet, Context context) {
    int arrayResourceId = attributeSet.getResourceId(R.styleable.GravView_grav_colors, 0);
    if (arrayResourceId != 0) {
      colors = context.getResources().getStringArray(arrayResourceId);
    }
  }
}
