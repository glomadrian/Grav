package com.github.glomadrian.grav.generator.point;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import java.util.Vector;

/**
 * Point generator
 *
 * @author manolovn
 * @author glommadrian
 */
public interface PointGenerator {
  Vector<PointF> generatePoints(int width, int height);
  void configure(AttributeSet attributeSet, Context context);
}