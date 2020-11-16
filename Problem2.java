import java.util.Random;
import java.util.Scanner;
public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int val = rand.nextInt(100)+1;
		int num1=1,num2=100;
		int cnt = 1;
		Scanner scan = new Scanner(System.in);
		int temp;
		do {
		System.out.print("[" + cnt + "] Guess a number (" + num1 + "-" + num2 + ") : " );
		temp = scan.nextInt();
		if(temp > num1 && temp < val) {
			System.out.println("Too small!");
			num1 = temp + 1;
			cnt++;
		}
		else if(temp < num2 && temp > val) {
			System.out.println("Too large!");
			num2 = temp - 1;
			cnt++;
		}
		else if(temp > num2 || temp < num1){
			System.out.println("Not in range!");
		}
		}while(temp != val);
		System.out.println("Correct! Number of guesses: " + cnt);
		
		scan.close();
	}
}
