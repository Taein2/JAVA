import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Fruit{
	private String str;
	private double val;
	Fruit(String str, double val){
		this.str = str;
		this.val = val;
	}
	public String toString() {
		return this.str + " " + this.val;
	}
	public String getStr() {
		return this.str;
	}
	public double getVal() {
		return this.val;
	}
}
class FruitBox<T extends Fruit>{
	private ArrayList<T> list = new ArrayList<T>();
	private T maxItem;
	private T minItem;
	private double sum=0;
	void add(T item) {
		list.add(item);
		System.out.println(item);
		if(list.size() == 1) {
			maxItem = item;
			minItem = item;
		}else {
			if(item.getVal() > maxItem.getVal()) {
				maxItem = item;
			}
			if(item.getVal() < minItem.getVal()) {
				minItem = item;
			}
		}
		sum += item.getVal();
	}
	public int getNumItems() {
		return list.size();
	}
	public String getMaxItem() {
		return maxItem.getStr();
	}
	public double getMaxPrice() {
		return maxItem.getVal();
	}
	public String getMinItem() {
		return minItem.getStr();
	}
	public double getMinPrice() {
		return minItem.getVal();
	}
	public double getAvgPrice() {
		return sum/list.size();
	}

}
class ItemReader{
	private static BufferedReader br = null; 
	private static String str[], line;
	private static Fruit fruit;
	public static boolean fileToBox(String file, FruitBox<Fruit> t) {
		try {
    		br = new BufferedReader(new FileReader(file));   			
        }catch(FileNotFoundException e) {
        	System.out.println("Input file Not found.");
        	return false;
        }
		try{
			while(true) {
			line = br.readLine();
			if(line == null) break;
			str = line.split(" ");
			fruit = new Fruit(str[0], Double.parseDouble(str[1]));
			t.add(fruit);
			}
		}catch (IOException e) {
		}
		try{	br.close();		}catch(IOException e){}
        	
		return true;
	}
}

public class Problem14 {
	public static void main(String[] args) {
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if(rv == false) return;
			box.add(new Fruit("orange", 9.99));
			System.out.println("----------------");
			System.out.println(" Summary");
			System.out.println("----------------");
			System.out.println("number of items: " + box.getNumItems());
			System.out.println("most expensive item: " + box.getMaxItem() + " (" +
			box.getMaxPrice() + ")");
			System.out.println("cheapest item: " + box.getMinItem() + " (" +
			box.getMinPrice() + ")");
			System.out.printf("average price of items: %.2f", box.getAvgPrice());}
}