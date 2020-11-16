import java.util.Scanner;
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("ASCII code teller. Enter a letter : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if(!str.isBlank()) {
			char ch = str.charAt(0);
				if(((ch >= 65 && ch <= 90) || (ch >= 97 && ch <=122)) && str.length() == 1) {
				int num = (int)ch;
				System.out.println("The ASCII code of " + ch + " is " + num );	
			}
		}
		else {
			System.out.println("You must input a single uppercase or lowercase alphabet.");
		}
		
		scan.close();
	}

}
