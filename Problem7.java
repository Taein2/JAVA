import java.util.Scanner;

interface IntSequenceStr{
	public abstract boolean hasNext();
	public abstract String next();
}
class BinarySequenceStr implements IntSequenceStr{
	private int num;
	String str = "";
	public BinarySequenceStr(int n) {
		num = n;
	}
	public boolean hasNext() {	return num!=0;	}
	public String next() {
		double temp = num;
		int cnt = -1;
		while(true) {
			temp = temp / 2;
			cnt++;
			if(temp < 1) break;
		}
		for(int i=cnt; i>=0; i--) {
			temp = Math.pow(2, i);
			if((num - temp) >= 0) {
				num -= temp;
				str += "1";
			}else {				
				str += "0";
			}
		}
		return str;
	}
}
public class Problem7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 System.out.print("Enter a positive integer: ");
		 String str = in.nextLine();
		 int num = Integer.parseInt(str);
		 in.close();
		 System.out.println("Integer: " + num);
		 IntSequenceStr seq = new BinarySequenceStr(num);
		 System.out.print("Binary number: ");
		 while(seq.hasNext()) System.out.print(seq.next());
		 System.out.println(" ");
	}
}
