import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.*;



class MapManager {
	private static BufferedReader br = null; 
	private static String str[], line, out, key;
	private static double value;
	private static Iterator<String> iter;
	private static Map<String,Double> map = new TreeMap<String,Double>(){
	public String toString() {
	      out = "";
	      iter = map.keySet().iterator(); 
	      while(iter.hasNext()) { 
	         key = iter.next(); 
		     value = map.get(key); 
		     out += key + " " + value;
		     if(iter.hasNext()) {
		    	 out += "\n";
		     }
		  }
	      return out;
		}
	};
	
	public static Map<String,Double> readData(String file) {
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
				key = str[0];
				value = Double.parseDouble(str[1]);
				map.put(key, value);
			}
			
		}catch(IOException e) {
		}
		return map;	
	}

}


public class Problem17 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if(map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
	
}