

class Point{
	private double[] arr;
	Point(double[] arr){
		this.arr = arr;
	}
	double[] get() {
		return this.arr;
	}
	
}

class EuclideanDistance{
	private static double result = 0;
	public static double getDist(Point a, Point b){
		if(a.get().length == b.get().length) {
			for(int i=0; i<a.get().length; i++) {
				 result += Math.pow((a.get()[i] - b.get()[i]), 2);
			}
            return Math.sqrt(result);
		}
		else	
			return -1;
	}
}

class ManhattanDistance{
	private static double result = 0;
	public static double getDist(Point a, Point b){
		if(a.get().length == b.get().length) {
			for(int i=0; i<a.get().length; i++) {
				 result += Math.abs(a.get()[i] - b.get()[i]);
			}
            return result;
		}
		else	
			return -1;
	}
}
public class Problem9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p2 = new Point(new double[] {4.0, 5.0, 6.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p4 = new Point(new double[] {4.0, 5.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4)); 	
	}
}
