package kethua1;

public class Cylinder extends Circle {
    double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder [radius=" + super.getRadius() + ", color=" + super.getColor() + "height=" + height + "]";
    }

    public double getVolume() {
        return Math.PI * super.getRadius() * super.getRadius() * height;
    }
}
