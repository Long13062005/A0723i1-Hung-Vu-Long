package main.java.oop;

public class Fan {
    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;
    private int speed;
    private boolean turn;
    private double radius;
    private String color;

    public Fan() {
        speed = SLOW;
        turn = false;
        radius = 0;
        color = "blue";
    }

    public Fan(int speed, boolean turn, double radius, String color) {
        this.speed = speed;
        this.turn = turn;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fan [speed=" + speed + ", turn=" + turn + ", radius=" + radius + ", color=" + color + "]";
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(FAST, true, 10, "Yellow");
        Fan fan2 = new Fan(MEDIUM, false, 5, "blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

    }
}
