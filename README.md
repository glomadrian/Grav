# Grav
[![Download](https://api.bintray.com/packages/glomadrian/maven/RoadRunner/images/download.svg) ](https://bintray.com/glomadrian/maven/RoadRunner/_latestVersion)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0) [![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)

<center>
<img src="./art/grav.png " alt="Drawing" width="250" />
</center>
</br>
<p>
Grav is a library for android which allow you to make multiple animations based
on points
<p/>

### Samples


  <com.github.glomadrian.grav.GravView
      android:id="@+id/grav"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:layout_centerInParent="true"
      app:colorGenerator="com.github.glomadrian.grav.generator.paint.OneColorGenerator"
      app:grav_color="@color/colorPrimary"
      />

  <com.github.glomadrian.grav.GravView
      android:id="@+id/grav"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:layout_centerInParent="true"
      app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
      app:grav_colors="@array/Spectral"
      />


        <com.github.glomadrian.grav.GravView
            android:id="@+id/grav"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_centerInParent="true"
            app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
            app:grav_colors="@array/Spectral"
            app:pointGenerator="com.github.glomadrian.grav.generator.point.CircularPointGenerator"
            app:cell_size="400"
            app:variance="100"
            />

              <com.github.glomadrian.grav.GravView
                  android:id="@+id/grav"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  android:layout_centerInParent="true"
                  app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
                  app:grav_colors="@array/Spectral"
                  app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
                  app:cell_size="400"
                  app:variance="200"
                  />
   <com.github.glomadrian.grav.GravView
       android:id="@+id/grav"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:layout_centerInParent="true"
       app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
       app:grav_colors="@array/Spectral"
       app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
       app:cell_size="100"
       app:variance="200"
       app:gravGenerator="com.github.glomadrian.grav.generator.grav.BallGravGenerator"
       app:size="3dp"
       />

      <com.github.glomadrian.grav.GravView
          android:id="@+id/grav"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:layout_centerInParent="true"
          app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
          app:grav_colors="@array/Spectral"
          app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
          app:cell_size="300"
          app:variance="200"
          app:gravGenerator="com.github.glomadrian.grav.generator.grav.RectangleGravGenerator"
          app:width="40dp"
          app:height="40dp"
          />



            <com.github.glomadrian.grav.GravView
                android:id="@+id/grav"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_centerInParent="true"
                app:colorGenerator="com.github.glomadrian.grav.generator.paint.ArrayColorGenerator"
                app:array_colors="@array/Spectral"
                app:pointGenerator="com.github.glomadrian.grav.generator.point.RegularPointGenerator"
                app:regular_cell_size="100"
                app:regular_variance="200"
                app:gravGenerator="com.github.glomadrian.grav.generator.grav.BallGenerator"
                app:ball_size="3dp"
                app:animationGenerators="@array/Animations"
                app:side_to_side_min_duration="2000"
                app:side_to_side_max_duration="5000"
                app:side_to_side_direction="downToUp"
                app:shake_variance="50dp"
                app:ball_size_from_size="3dp"
                app:ball_size_to_size="6dp"
                app:shake_direction="horizontal"
                />
                 <string-array name="Animations">
                    <item>com.github.glomadrian.grav.generator.animation.SideToSideAnimator</item>
                    <item>com.github.glomadrian.grav.generator.animation.ShakeAnimator</item>
                    <item>com.github.glomadrian.grav.generator.animation.BallSizeAnimator</item>
                  </string-array>
