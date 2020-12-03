import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;



class MapManager {
	private static BufferedReader br = null; 
	private static String str[], line, key, out;
	private static double value;
	private static List<Map.Entry<String, Double>> list = null; 
	private static Map<String,Double> map = new HashMap<String,Double>(){
		public String toString() {		      	
			list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Double>>(){
				public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
					if(o1.getValue() > o2.getValue()) return 1;
					if(o1.getValue() < o2.getValue()) return -1;
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			out = "";
			for(Map.Entry<String, Double> sortedMap : list) {
				out += sortedMap.getKey() + " " + sortedMap.getValue() + "\n";					
			}
		    return out.trim();
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


public class Problem18 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if(map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
	
}