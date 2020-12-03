import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Element implements Comparable<Element>{
	private String name;
	private double price;
	Element(String name, double price){
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	
	public int compareTo(Element o) {
		if(this.price > o.price) return 1;
		if(this.price < o.price) return -1;
		return this.name.compareTo(o.getName());
	}
	public String toString() {
		return this.name + " " + this.price;	
	}
}
class ElementReader{
	private static ArrayList<Element> list = new ArrayList<>();
	private static BufferedReader br = null; 
	private static String str[], line;
	private static Element item;
	
	public static ArrayList<Element> readElements(String file){
		try {
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			return null;
		}
		try {
			while(true) {
				line = br.readLine();
				if(line == null) break;
				str = line.split(" ");
				item = new Element(str[0],Double.parseDouble(str[1]));
				list.add(item);
			}
		}catch(IOException e) {
			
		}
		return list;
	}
}

public class Problem16 {
	public static void main(String args[]) {
			ArrayList<Element> list = ElementReader.readElements("input.txt");
			if(list == null) {
					System.out.println("Input file not found.");
					return;
			}
			Collections.sort(list);
			Iterator<Element> it = list.iterator();
			while(it.hasNext()) System.out.println(it.next());
	}
}
