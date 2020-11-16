import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Item{
	private int cnt;
	private String str;
	Item(String str, int cnt){
		this.str = str;
		this.cnt = cnt;
	}
	public String getStr() {
		return this.str;
	}
	public int getCnt() {
		return this.cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String toString() {
		return this.str + " " + this.cnt;
	}
}
class MyFileReader{
	private static BufferedReader br = null; 
	private static String str[], line;
	private static boolean flag;
	public static boolean readDataFromFile(String file, ArrayList<Item> list) {
		try{
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			return false;
		}
		try{
			while(true) {
				line = br.readLine();
				if(line == null) break;
				line = line.toString().toLowerCase();
				str = line.split(" ");
			}
			for(int i=0; i<str.length; i++) {
				flag=true;
				for(Item it: list) {
					if(it.getStr().equals(str[i])) {
						it.setCnt(it.getCnt()+1);
						flag=false;
					}
				}
				if(flag == true) {
				Item item = new Item(str[i],1);
				list.add(item);	
				}
			}
			
		}catch (IOException e) {
		}
		try{	br.close();	}catch(IOException e){ }
	
		return true;
	}
}

public class Problem15 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if(rv == false) {
			System.out.println("Input file not found.");
			return;
		}
		for(Item it: list) System.out.println(it);
	}
}
