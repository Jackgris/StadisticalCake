package ar.com.demo.newcompany.virtualwallet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    private ImageView iView_cake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyView(this));


    }

    public class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            float width = (float)getWidth();
            float height = (float)getHeight();
            float radius;
            if (width > height){
                radius = height/4;
            }else{
                radius = width/4;
            }
            Path path = new Path();
            path.addCircle(width/2,
                    height/2, radius,
                    Path.Direction.CW);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.FILL);
            float center_x, center_y;
            center_x = width/2;
            center_y = height/4;
            final RectF oval = new RectF();
            oval.set(center_x - radius,
                    center_y - radius,
                    center_x + radius,
                    center_y + radius);
            canvas.drawArc(oval, 90, 270, true, paint);
            paint.setStyle(Paint.Style.STROKE);
            center_x = width/2;
            center_y = height/2;
            oval.set(center_x - radius,
                    center_y - radius,
                    center_x + radius,
                    center_y + radius);
            canvas.drawArc(oval, 90, 270, true, paint);
            paint.setStyle(Paint.Style.STROKE);
            center_x = width/2;
            center_y = height * 3/4;
            oval.set(center_x - radius,
                    center_y - radius,
                    center_x + radius,
                    center_y + radius);
            canvas.drawArc(oval, 90, 270, false, paint);
        }

    }

}
