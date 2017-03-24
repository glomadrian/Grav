package com.github.glomadrian.grav.generator.point;

import android.graphics.PointF;
import java.util.Vector;

/**
 * Point generator
 *
 * @author manolovn
 */
public interface PointGenerator {
    Vector<PointF> generatePoints(int width, int height, int cellSize, int variance);
    void setBleedX(int bleedX);
    void setBleedY(int bleedY);
}