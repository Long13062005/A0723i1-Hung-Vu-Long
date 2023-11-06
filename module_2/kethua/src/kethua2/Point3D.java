package kethua2;

public class Point3D extends Point2D {
    float z;

    public Point3D() {
        z = 0.0f;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;

    }

    public float[] getXYZ() {
        return new float[] { super.getX(), super.getY(), z };
    }

    @Override
    public String toString() {
        return "Point3D [x=" + super.getX() + ", y=" + super.getY() + "z=" + z + "]";
    }

}
