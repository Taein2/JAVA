import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class Text {
	private int cnt;
	private BufferedReader br = null; 
	private String str="", line="";
    public boolean readTextFromFile(String file){
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
				str += line.toLowerCase();
    		}
    	}catch (IOException e) {		}
    	try{	br.close();		}catch(IOException e){ }
    	return true;
    }
    public int countChar(char ch) {
    	cnt = 0;
    	for(int i =0; i< str.length(); i++) {
    		if(str.charAt(i) == ch) cnt ++;
    	}
    	return cnt;
    }
}
public class Problem13 {
	public static void main(String[] args) {
		Text t = new Text();
		if(t.readTextFromFile("input_prob13.txt")) {
			for(char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + t.countChar(c));
			}
		}
	}
}
