package com.github.glomadrian.grav;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.glomadrian.grav.figures.Grav;
import com.github.glomadrian.grav.generator.GeneratorFactory;
import com.github.glomadrian.grav.generator.animation.GravAnimatorGenerator;
import com.github.glomadrian.grav.generator.grav.GravGenerator;
import com.github.glomadrian.grav.generator.paint.PaintGenerator;
import com.github.glomadrian.grav.generator.point.PointGenerator;
import java.util.Vector;

public class GravView extends View {
  private PointGenerator pointGenerator;
  private PaintGenerator paintGenerator;
  private Vector<GravAnimatorGenerator> gravAnimatorGenerators;
  private GravGenerator gravGenerator;
  private Vector<Grav> gravVector;
  private Vector<ValueAnimator> gravAnimators;
  private ValueAnimator viewRefreshAnimator;

  public GravView(Context context) {
    super(context);
    initialize(null);
  }

  public GravView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    initialize(attrs);
  }

  public GravView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(attrs);
  }

  private void initialize(AttributeSet attrs) {
    GeneratorFactory generatorFactory = new GeneratorFactory(getContext());
    initializeRefreshAnimator();
    if (attrs != null) {
      TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.GravView, 0, 0);
      try {
        paintGenerator = generatorFactory.createPaint(typedArray.getString(R.styleable.GravView_colorGenerator), attrs);
        pointGenerator = generatorFactory.createPoint(typedArray.getString(R.styleable.GravView_pointGenerator), attrs);
        gravGenerator = generatorFactory.createGrav(typedArray.getString(R.styleable.GravView_gravGenerator), attrs);
        gravAnimatorGenerators = obtainGravAnimators(attrs, typedArray, generatorFactory);
      } finally {
        typedArray.recycle();
      }
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        start();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    });
  }

  private Vector<GravAnimatorGenerator> obtainGravAnimators(AttributeSet attributeSet, TypedArray attributes,
                                                           GeneratorFactory generatorFactory) {
    Vector<GravAnimatorGenerator> gravAnimatorGenerators = new Vector<>();
    int arrayResourceId = attributes.getResourceId(R.styleable.GravView_animationGenerators, 0);
    if (arrayResourceId != 0) {
      obtainAnimatorsFromArray(attributeSet, generatorFactory, gravAnimatorGenerators, arrayResourceId);
    } else {
      obtainAnimatorFromSingleAttribute(attributeSet, attributes, generatorFactory, gravAnimatorGenerators);
    }
    return gravAnimatorGenerators;
  }

  private void obtainAnimatorFromSingleAttribute(AttributeSet attributeSet, TypedArray attributes,
                                                GeneratorFactory generatorFactory,
                                                Vector<GravAnimatorGenerator> gravAnimatorGenerators) {
    GravAnimatorGenerator gravAnimatorGenerator =
    generatorFactory.createAnimator(attributes.getString(R.styleable.GravView_animationGenerator), attributeSet);
    if (gravAnimatorGenerator != null) {
      gravAnimatorGenerators.add(gravAnimatorGenerator);
    }
  }

  private void obtainAnimatorsFromArray(AttributeSet attributeSet, GeneratorFactory generatorFactory,
                                       Vector<GravAnimatorGenerator> gravAnimatorGenerators, int arrayResourceId) {
    String[] animationGeneratorsString = getContext().getResources().getStringArray(arrayResourceId);
    for (String generatorString : animationGeneratorsString) {
      GravAnimatorGenerator gravAnimatorGenerator = generatorFactory.createAnimator(generatorString, attributeSet);
      if (gravAnimatorGenerator != null) {
        gravAnimatorGenerators.add(gravAnimatorGenerator);
      }
    }
  }

  private void initializeRefreshAnimator() {
    viewRefreshAnimator = ValueAnimator.ofInt(0, 1);
    viewRefreshAnimator.setRepeatCount(ValueAnimator.INFINITE);
    viewRefreshAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        invalidate();
      }
    });
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    Vector<PointF> points = pointGenerator.generatePoints(w, h);
    gravVector = generateBallFrom(points);
    gravAnimators = generateGravAnimatorsFrom(gravVector);
  }

  private Vector<Grav> generateBallFrom(Vector<PointF> points) {
    Vector<Grav> vector = new Vector<>(points.size());
    for (PointF point : points) {
      Paint paint = paintGenerator.generate();
      Grav grav = gravGenerator.generate(point, paint);
      vector.add(grav);
    }
    return vector;
  }

  private Vector<ValueAnimator> generateGravAnimatorsFrom(Vector<Grav> gravVector) {
    Vector<ValueAnimator> valueAnimators = new Vector<>(gravVector.size());
    for (Grav grav : gravVector) {
      for (GravAnimatorGenerator gravAnimatorGenerator : gravAnimatorGenerators) {
        ValueAnimator valueAnimator = gravAnimatorGenerator.generateGravAnimator(grav, getWidth(), getHeight());
        valueAnimators.add(valueAnimator);
      }
    }
    return valueAnimators;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    for (Grav grav : gravVector) {
      grav.draw(canvas);
    }
  }

  public void start() {
    viewRefreshAnimator.start();
    for (ValueAnimator valueAnimator : gravAnimators) {
      valueAnimator.start();
    }
  }

  public void stop(){
    viewRefreshAnimator.setRepeatCount(0);
    viewRefreshAnimator.removeAllListeners();
    viewRefreshAnimator.removeAllUpdateListeners();
    viewRefreshAnimator.cancel();
    viewRefreshAnimator.end();
    for (ValueAnimator valueAnimator : gravAnimators) {
      valueAnimator.setRepeatCount(0);
      valueAnimator.removeAllListeners();
      valueAnimator.removeAllUpdateListeners();
      valueAnimator.cancel();
      valueAnimator.end();
    }
  }
}
