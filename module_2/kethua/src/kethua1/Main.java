package kethua1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.2, "blue");
        Cylinder cylinder = new Cylinder(1.2, "blue", 1.5);
        System.out.println(circle);
        System.out.println(cylinder);
        System.out.println(circle.getArea());
        System.out.println(cylinder.getVolume());
    }
}
