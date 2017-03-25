package com.github.glomadrian.grav.generator.point;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import java.util.Vector;

/**
 * Point generator
 *
 * @author manolovn
 */
public interface PointGenerator {
    Vector<PointF> generatePoints(int width, int height);
    void configure(TypedArray attributeSet, Context context);
}