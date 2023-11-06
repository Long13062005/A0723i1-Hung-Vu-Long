package kethua2;

public class Main {
    public static void main(String[] args) {
        Point2D p = new Point2D();
        Point3D point3d = new Point3D();
        p.setXY(1, 2);
        point3d.setXYZ(1, 2, 3);
        System.out.println(p);
        System.out.println(point3d);
    }
}
