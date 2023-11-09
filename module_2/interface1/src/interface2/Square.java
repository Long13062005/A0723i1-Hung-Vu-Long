package interface2;

public class Square extends Shape implements Colorable{
    private double length =1.0;

    public Square() {
    }
    public Square(double length) {
        this.length = length;
    }

    public Square(String color, boolean filled, double length) {
        super(color, filled);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return Math.pow(this.length,2);
    }

    public double getPerimeter() {
        return 2 * this.length;
    }
    @Override
    public String toString() {
        return "A Square with length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }
	@Override
	public void howToGo() {
		// TODO Auto-generated method stub
		System.out.println("Color all four sides.");
		
	}
   
}