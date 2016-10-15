package test.cbuitest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naman on 15/10/16.
 */
public class MyCustomView extends View {

    Paint paint;
    Path path;
    Context context;
    int color;
    float radius;

    public MyCustomView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        this.color = ta.getColor(R.styleable.MyCustomView_circlecolor, Color.GREEN);
        this.radius = ta.getDimension(R.styleable.MyCustomView_circleradius, 100f);
        ta.recycle();

        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defSTyle) {
        super(context, attrs, defSTyle);
        init(context);
    }

    private void init(Context context) {

        this.context = context;

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);

        path = new Path();
        path.moveTo(0,0);
        path.lineTo(500, 0);
        path.lineTo(500, 1000);
        path.lineTo(1000, 1000);
        path.lineTo(0,0);
        path.close();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, radius, paint);
//        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
