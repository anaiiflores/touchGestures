package com.example.bienmovimientos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gestureDetector = new GestureDetector(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();

            if (Math.abs(diffY) > Math.abs(diffX)) {

                if (diffY < -SWIPE_THRESHOLD) {

                    Toast.makeText(MainActivity.this, "Arriba", Toast.LENGTH_SHORT).show();
                } else if (diffY > SWIPE_THRESHOLD) {

                    Toast.makeText(MainActivity.this, "Abajo", Toast.LENGTH_SHORT).show();
                }
            } else {

                if (diffX < -SWIPE_THRESHOLD) {

                    Toast.makeText(MainActivity.this, "Izquierda", Toast.LENGTH_SHORT).show();
                } else if (diffX > SWIPE_THRESHOLD) {

                    Toast.makeText(MainActivity.this, "Derecha", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }
    }
}
