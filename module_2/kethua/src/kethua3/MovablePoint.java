package kethua3;

public class MovablePoint extends Point {
    float xSpeed, ySpeed;

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
        xSpeed = 0.0f;
        ySpeed = 0.0f;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float x, float y) {
        this.xSpeed = x;
        this.ySpeed = y;
    }

    public float[] getSpeed() {
        return new float[] { xSpeed, ySpeed };
    }

    @Override
    public String toString() {
        return "MovablePoint [x=" + x + ", y=" + y + "xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
    }

    public MovablePoint move() {
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);
        return this;
    }
}
