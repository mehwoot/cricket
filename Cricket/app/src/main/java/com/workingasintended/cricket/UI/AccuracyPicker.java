package com.workingasintended.cricket.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

import com.workingasintended.cricket.game.Shot;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gareth on 06 Apr.
 */
public class AccuracyPicker extends SurfaceView {

    protected Shot shot;
    protected Timer timer;
    private AccuracyPicker self;

    @Override
    protected void onDraw(Canvas canvas) {
        if (this.shot != null) {
            Paint p = new Paint();

            
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            int margins = width / 8;
            int centreSize = width - (margins * 2);
            int yellowStart = margins + (int)(centreSize * (shot.targetPosition - (shot.yellowWidth / 2.0)));
            int yellowEnd = margins + (int)(centreSize * (shot.targetPosition + (shot.yellowWidth / 2.0)));
            int greenStart = margins + (int)(centreSize * (shot.targetPosition - (shot.greenWidth / 2.0)));
            int greenEnd = margins + (int)(centreSize * (shot.targetPosition + (shot.greenWidth / 2.0)));
            int blackPosition = (int)(width * shot.shotPosition);

            p.setColor(Color.RED);
            canvas.drawRect(0,0,width,height, p);

            p.setColor(Color.YELLOW);
            canvas.drawRect(yellowStart, 0, yellowEnd, height, p);

            p.setColor(Color.GREEN);
            canvas.drawRect(greenStart, 0, greenEnd, height, p);

            p.setColor(Color.BLACK);
            canvas.drawRect(blackPosition, 0, blackPosition + 2, height, p);

        } else {
            Paint p = new Paint();
            p.setColor(Color.TRANSPARENT);
            canvas.drawRect(0, 0, 1000, 1000, p);
        }

    }

    public AccuracyPicker(Context context) {
        super(context);
        init(context);
    }

    public AccuracyPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AccuracyPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void setShot(Shot shot) {
        this.shot = shot;
        if (timer == null) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    mHandler.obtainMessage(1).sendToTarget();
                }
            }, 0, 20);
        }
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (shot != null) {
            shot.stop();
            Log.d("accuracypicker", "" + shot.shotQuality);
        }

    }

    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            shot.stepPosition(0.01);
            self.invalidate();
        }
    };

    private void init(Context context) {
        setWillNotDraw(false);
        self = this;
    }
}
