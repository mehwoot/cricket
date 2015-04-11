package com.workingasintended.cricket.game;

import android.util.Log;

/**
 * Created by gareth on 06 Apr.
 */
public class Shot {
    public double targetPosition;
    public double yellowWidth;
    public double greenWidth;
    public double shotPosition;
    public double shotQuality;
    private boolean increasing;

    public Shot() {
        targetPosition = 0.0;
        yellowWidth = 0.15;
        greenWidth = 0.06;
        shotPosition = 0.0;
        increasing = true;
    }

    public void stepPosition(double timestep) {
        shotPosition += increasing ? timestep : -timestep;
        if (shotPosition > 1.0 || shotPosition < 0.0) {
            increasing = !increasing;
            shotPosition = Math.max(0.0, shotPosition);
            shotPosition = Math.min(1.0, shotPosition);
        }

    }

    public void stop() {
        Log.d("shot", String.format("%.2f %.2f %.2f %.2f", shotPosition, targetPosition, greenWidth, yellowWidth));
        if (shotPosition > (targetPosition - (greenWidth / 2.0)) && shotPosition < (targetPosition + (greenWidth / 2))) {
            shotQuality = 1.0;
        } else {
            if (shotPosition > (targetPosition - (yellowWidth / 2.0)) && shotPosition < (targetPosition + (yellowWidth / 2))) {
                shotQuality = 0.5;
            } else {
                shotQuality = 0.0;
            }
        }
    }
}
