package test.cbuitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naman on 15/10/16.
 */
public class RunnableCustomView extends View {

    float radius = 0;
    Paint paint;

    public RunnableCustomView(Context context) {
        super(context);
        init();
    }

    public RunnableCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#009688"));

        post(animateRadius);
    }

    private Runnable animateRadius = new Runnable() {
        @Override
        public void run() {

            boolean reachedEnd = false;

            if (radius <= 500) {
                radius = radius + 10;

            } else reachedEnd = true;

            invalidate();

            if (!reachedEnd) {
                postDelayed(this, 10);
            }

        }
    };


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
    }
}
