package com.github.glomadrian.grav.generator;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import com.github.glomadrian.grav.generator.animation.GravAnimatorGenerator;
import com.github.glomadrian.grav.generator.animation.ShakeAnimator;
import com.github.glomadrian.grav.generator.grav.BallGravGenerator;
import com.github.glomadrian.grav.generator.grav.GravGenerator;
import com.github.glomadrian.grav.generator.paint.PaintGenerator;
import com.github.glomadrian.grav.generator.paint.RandomColorGenerator;
import com.github.glomadrian.grav.generator.point.PointGenerator;
import com.github.glomadrian.grav.generator.point.RegularPointGenerator;
import com.github.glomadrian.grav.util.ClassUtil;

public class GeneratorFactory {
  private Context context;

  public GeneratorFactory(Context context) {
    this.context = context;
  }

  public PaintGenerator createPaint(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return new RandomColorGenerator();
    }
    PaintGenerator paintGenerator = ClassUtil.getClassByName(className, PaintGenerator.class);
    paintGenerator.configure(attributeSet, context);
    return paintGenerator;
  }

  public PointGenerator createPoint(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return new RegularPointGenerator();
    }
    PointGenerator generator = ClassUtil.getClassByName(className, PointGenerator.class);
    generator.configure(attributeSet, context);
    return generator;
  }

  public GravGenerator createGrav(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return new BallGravGenerator();
    }
    GravGenerator generator = ClassUtil.getClassByName(className, GravGenerator.class);
    generator.configure(attributeSet, context);
    return generator;
  }

  public GravAnimatorGenerator createAnimator(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return new ShakeAnimator();
    }
    GravAnimatorGenerator generator = ClassUtil.getClassByName(className, GravAnimatorGenerator.class);
    generator.configure(attributeSet, context);
    return generator;
  }

  @Nullable
  public GravAnimatorGenerator createAnimatorWithoutDefault(String className, TypedArray attributeSet) {
    if (className == null || className.isEmpty()) {
      return null;
    }
    GravAnimatorGenerator generator = ClassUtil.getClassByName(className, GravAnimatorGenerator.class);
    generator.configure(attributeSet, context);
    return generator;
  }
}
