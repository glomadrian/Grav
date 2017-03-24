package com.github.glomadrian.grav.generator;

import android.content.res.TypedArray;
import com.github.glomadrian.grav.generator.paint.PaintGenerator;
import com.github.glomadrian.grav.generator.paint.RandomColorGenerator;
import com.github.glomadrian.grav.util.ClassUtil;

public class GeneratorFactory {
  public PaintGenerator create(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return new RandomColorGenerator();
    }
    PaintGenerator paintGenerator = ClassUtil.getClassByName(className, PaintGenerator.class);
    paintGenerator.configure(attributeSet);
    return paintGenerator;
  }
}
