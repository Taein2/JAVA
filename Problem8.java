

interface Shape{
	public abstract double area();
}

class Circle implements Shape{
	private double area=0;
	private double n1;
	public Circle(double n1) {
		this.n1 = n1;
	}
	public double area() {
		area = Math.PI * n1 * n1;
		return area;
	}
		
}

class Square implements Shape {
	private double area=0;
	private double n1;
	public Square(double n1) {
		this.n1 = n1;
	}
	public double area() {
		area = n1 * n1;
		return area;
	}
}

class Rectangle implements Shape{
	private double area = 0;
	private double n1, n2;
	public Rectangle(double n1, double n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	public double area() {
		area = n1 * n2;
		return area;
	}
}

public class Problem8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] arr = { new Circle(5.0), new Square(4.0),
		new Rectangle(3.0, 4.0), new Square(5.0)};
		System.out.println("Total area of the shapes is: " + sumArea(arr));	
	}
	private static double sumArea(Shape[] arr) {
		double sum = 0;
		for(int i =0; i< arr.length; i++) {
			sum = sum + arr[i].area();
		}
		return sum;
	}
}
