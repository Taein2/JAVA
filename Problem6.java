
interface IntSequence{
	public abstract boolean hasNext();
	public abstract int next();
}

class FibonacciSequence implements IntSequence{
	
	private int num1 = 0;
	private int num2 = 1;
	private int cnt = 0;
	public boolean hasNext() {
		return (num1 >= 0 && num2 >= 1 && cnt >= 0 );
	}
	public int next() {
		int result;
		if(cnt == 0 ) {
			result = num1;
			cnt++;
			return result;
		}
		else if (cnt == 1) {
			result = num2;
			cnt++;
			return result;
		}
		else {
		result = num1 + num2;
		num1 = num2;
		num2 = result;
		cnt++;
		return result;
		}
		
	}
}

public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSequence seq = new FibonacciSequence();
		 for(int i=0; i<20; i++) {
			 if(seq.hasNext() == false) break;
			 System.out.print(seq.next() + " ");
		 }
		 System.out.println(" ");
		
	}
}
