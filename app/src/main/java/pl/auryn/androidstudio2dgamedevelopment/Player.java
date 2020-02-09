package pl.auryn.androidstudio2dgamedevelopment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

class Player {
    private float positionX;
    private float positionY;
    private float radius;
    private Paint paint;

    public Player (Context context, float positionX, float positionY, float radius) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;

        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);

    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(positionX, positionY, radius, paint);
    }

    public void update() {
    }

    public void setPosition(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
