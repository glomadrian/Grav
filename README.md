# Grav
[![Download](https://api.bintray.com/packages/glomadrian/maven/RoadRunner/images/download.svg) ](https://bintray.com/glomadrian/maven/RoadRunner/_latestVersion)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0) [![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)

<p align="center">
<img src="./art/grav.png " alt="Drawing" width="250" />
</br>
</center>
<p>
Grav is a library for android which allow you to make multiple animations based
on points
<p/>

<p align="center">
<img src="./art/wave.gif " alt="Drawing" width="200" />
<img src="./art/login.gif " alt="Drawing" width="200" />
<img src="./art/path.gif " alt="Drawing" width="200" />
<img src="./art/falcon.gif " alt="Drawing" width="200" />
<img src="./art/grav.gif " alt="Drawing" width="200" />
<img src="./art/robot.gif " alt="Drawing" width="200" />
<p/>

# How use it

The library is composed of generators, each generator take care about one thing
composing different generators you can obtain different results.

There are different kind of generators

 - Point generator
 - Grav generator
 - Color generator
 - Animation generator


## Point generator
The point generator is the class that create the points locations that later will
be draw using a Grav Generator.
To use you need to set the attribute:
```java
app:pointGenerator="classname"
```
The first thing you need is a Point generator, the are 3 generators available:

### Regular point generator

Generate points based on a cell and a variance
```java
app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
app:regular_cell_size="200"
app:regular_variance="20"
```
(Using in conbination with GravBallGeneartor)

<img src="./art/regular_generator.png " alt="Drawing" width="200" />

### Circular point generator

Generate points based on a cell and a variance in a circular shape
```java
app:pointGenerator="com.github.glomadrian.grav.generator.point.CircularPointGenerator"
app:regular_cell_size="200"
app:regular_variance="200"
```

(Using in conbination with GravBallGeneartor)

<img src="./art/circular_generator.png" alt="Drawing" width="200" />

### Percent point generator
Generate the points based on percent locations array
```java
app:pointGenerator="com.github.glomadrian.grav.generator.point.PercentPointGenerator"
app:percent_points_array="@array/walla_points_percent_points"
```
inside arrays.xml
Each pair of items represents a point in the view, defined in percent width and
height
```java
<integer-array name="walla_points_percent_points">
   <item>10</item>
   <item>60</item>

   <item>8</item>
   <item>30</item>

   <item>25</item>
   <item>10</item>
 </integer-array>
```
(Using in conbination with GravBallGeneartor)

<img src="./art/percent_generator.png " alt="Drawing" width="200" />

## Grav Generator

Grav generator is the piece in charge of draw every point previously generated.
To use you need to set the attribute:
```java
app:gravGenerator="classname"
```
There are two Grav Generator available


### Ball Generator

Draw a Ball

The sizes of the balls can be randomized in a range using the attributes below

```java
app:gravGenerator="com.github.glomadrian.grav.generator.grav.BallGenerator"
app:ball_from_size="3dp"
app:ball_to_size="16dp"
```

<img src="./art/ball_size_range.png " alt="Drawing" width="200" />


### RectangleGenerator

Draw rectangles

The size of the rectangles can be change with the attributes below:

```java
app:gravGenerator="com.github.glomadrian.grav.generator.grav.RectangleGenerator"
app:rectangle_width="15dp"
app:rectangle_height="10dp"
```
<img src="./art/rectangle_grav.png " alt="Drawing" width="200" />


## Color Generator
Color generator decide how the Grav are painted

To use you need to set the attribute:
```java
appcolorGenerator="classname"
```
There are two Color Generator available

### Single Color Generator

Paint in one single color

```java
app:colorGenerator="com.github.glomadrian.grav.generator.paint.SingleColorGenerator"
app:single_color="@color/colorPrimary"
```
### Array Color Generator

Paint using array of colors

```java
app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
app:array_colors="@array/Spectral"
```

<img src="./art/ball_color.png " alt="Drawing" width="200" />


## Animation Generator
The animation generator takes care about the position, size and properties
animation. The animation generator can be one or an array of animation generators

### Single Animation Generator

To use you need to set the attribute:

```java
app:animationGenerator="classname"
```

### Array Animation Generator

To use you need to set the attribute:

```java
app:animationGenerators="@array/array_reference"

<string-array name="array_reference">
  <item>com.github.glomadrian.grav.generator.animation.PathAnimator</item>
  <item>com.github.glomadrian.grav.generator.animation.BallSizeAnimator</item>
</string-array>
```

### Shake animator

Move the grav in a range

```java
app:animationGenerator=" com.github.glomadrian.grav.generator.animation.ShakeAnimator"
//Min animation duration
app:shake_min_duration="1000"
//Max animation duration
app:shake_max_duration="3000"
//Direction horizontal or vertical
app:shake_direction="horizontal"
//The size of the movement
app:shake_variance="15dp"
```

<img src="./art/shake_anim.gif " alt="Drawing" width="200" />

### Side to side animator

Move grav from one side to other

```java
app:animationGenerator="com.github.glomadrian.grav.generator.animation.SideToSideAnimator"
//Min animation duration
app:side_to_side_min_duration="1000"
//Max animation duration
app:side_to_side_max_duration="3000"
//Direction leftToRight | rightToLeft | upToDown | downToUp
app:side_to_side_direction="leftToRight"
```

Also you can use a interpolator for the animation

```java
side_to_side_interpolator="interpolator class"
```

<img src="./art/side_to_side.gif " alt="Drawing" width="200" />

### Alpha animator

Apply alpha animation to a grav

```java
app:animationGenerator="com.github.glomadrian.grav.generator.animation.AlphaAnimator"
//Min animation duration
app:alpha_min_duration="1000"
//Max animation duration
app:alpha_max_duration="3000"
//From and to in a range (0-255)
app:alpha_from="0"
app:alpha_to="255"
```

### Ball size animmator

Animate to one size to another
```java
app:animationGenerator="com.github.glomadrian.grav.generator.animation.BallSizeAnimator"
//Min animation duration
app:ball_size_min_duration="1000"
//Max animation duration
app:ball_size_max_duration="3000"
app:ball_size_from_size="3dp"
app:ball_size_to_size="8dp"
```
<img src="./art/size_to_size.gif " alt="Drawing" width="200" />

### Path animator


## XML Samples


<img src="./art/wave.gif " alt="Drawing" width="250" />

```java
<com.github.glomadrian.grav.GravView
     android:id="@+id/grav"
     android:layout_centerInParent="true"
     android:layout_width="400dp"
     android:layout_height="400dp"
     app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
     app:array_colors="@array/red"
     app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
     app:regular_cell_size="150"
     app:regular_variance="100"
     app:gravGenerator="com.github.glomadrian.grav.generator.grav.BallGenerator"
     app:ball_size_from_size="3dp"
     app:ball_size_to_size="6dp"
     app:animationGenerators="@array/path"
     app:path_variance_from="-10dp"
     app:path_variance_to="12dp"
     app:path="@string/circle"
     app:path_original_width="@integer/circle_original_width"
     app:path_original_height="@integer/circle_original_height"
     app:path_min_duration="5000"
     app:path_max_duration="6000"
     />
```


<img src="./art/login.gif " alt="Drawing" width="250" />

```java
<com.github.glomadrian.grav.GravView
     android:id="@+id/grav"
     android:layout_centerInParent="true"
     android:layout_width="400dp"
     android:layout_height="400dp"
     app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
     app:array_colors="@array/red"
     app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
     app:regular_cell_size="150"
     app:regular_variance="100"
     app:gravGenerator="com.github.glomadrian.grav.generator.grav.BallGenerator"
     app:ball_size_from_size="3dp"
     app:ball_size_to_size="6dp"
     app:animationGenerators="@array/path"
     app:path_variance_from="-10dp"
     app:path_variance_to="12dp"
     app:path="@string/circle"
     app:path_original_width="@integer/circle_original_width"
     app:path_original_height="@integer/circle_original_height"
     app:path_min_duration="5000"
     app:path_max_duration="6000"
     />
```
