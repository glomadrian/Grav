package com.github.glomadrian.grav.generator.grav;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import com.github.glomadrian.grav.R;
import com.github.glomadrian.grav.figures.GravBall;
import com.github.glomadrian.grav.figures.Grav;
import java.util.Random;

public class BallGenerator implements GravGenerator {
  private float size = 20;
  private float fromSize = size;
  private float toSize = size;
  private Random random = new Random();

  @Override
  public Grav generate(PointF startPoint, Paint paint) {
    return new GravBall(startPoint, paint, (int) getSizeInRange(fromSize, toSize));
  }

  private float getSizeInRange(float from ,float to){
    return random.nextFloat() * (from - to) + to;
  }

  @Override
  public void configure(AttributeSet attributeSet, Context context) {
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BallGenerator, 0, 0);
    size = attributes.getDimension(R.styleable.BallGenerator_ball_size, size);
    fromSize = attributes.getDimension(R.styleable.BallGenerator_ball_from_size, size);
    toSize = attributes.getDimension(R.styleable.BallGenerator_ball_to_size, size);
    attributes.recycle();
  }
}
