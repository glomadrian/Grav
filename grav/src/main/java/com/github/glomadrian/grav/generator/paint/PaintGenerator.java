package com.github.glomadrian.grav.generator.paint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;

public interface PaintGenerator {
  Paint generate();
  void configure(TypedArray attributeSet, Context context);
}
