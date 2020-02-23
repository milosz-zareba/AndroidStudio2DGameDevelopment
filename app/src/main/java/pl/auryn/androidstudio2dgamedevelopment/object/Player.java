package pl.auryn.androidstudio2dgamedevelopment.object;

import android.content.Context;

import androidx.core.content.ContextCompat;

import pl.auryn.androidstudio2dgamedevelopment.GameLoop;
import pl.auryn.androidstudio2dgamedevelopment.Joystick;
import pl.auryn.androidstudio2dgamedevelopment.R;
import pl.auryn.androidstudio2dgamedevelopment.Utils;

public class Player extends Circle {

    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private final Joystick joystick;

    public Player (Context context, Joystick joystick, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
    }

    public void update() {

        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        // Update position
        positionX += velocityX;
        positionY += velocityY;

        // Update direction
        if (velocityX != 0 || velocityY != 0) {
            // Normalize velocity to get direciton (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX / distance;
            directionY = velocityY / distance;

        }

    }

}
