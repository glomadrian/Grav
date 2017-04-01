# Grav
[![Download](https://api.bintray.com/packages/glomadrian/maven/RoadRunner/images/download.svg) ](https://bintray.com/glomadrian/maven/RoadRunner/_latestVersion)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0) [![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)

<center>
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

## How use it


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
