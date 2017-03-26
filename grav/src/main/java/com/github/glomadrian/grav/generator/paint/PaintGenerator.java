package com.github.glomadrian.grav.generator.paint;

import android.content.Context;

import android.graphics.Paint;
import android.util.AttributeSet;

public interface PaintGenerator {
  Paint generate();
  void configure(AttributeSet attributeSet, Context context);
}
