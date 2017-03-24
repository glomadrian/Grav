package com.github.glomadrian.grav.generator.grav;

import android.graphics.Paint;
import android.graphics.PointF;
import com.github.glomadrian.grav.figures.Grav;

public interface GravGenerator {
  Grav generate(PointF startPoint, Paint paint);
}
