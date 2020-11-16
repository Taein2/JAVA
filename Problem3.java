import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str, word;
		char[] arr;
		char ch;
		int cnt = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a text: ");
		str = scan.nextLine();
		arr = str.toCharArray();

		while(true) {
			System.out.print("Enter a letter: ");
			word = scan.nextLine();
			if(word.length() == 1 && !word.isBlank()) {
				ch = word.charAt(0);
					for(int i = 0; i<arr.length; i++) {
					if(arr[i] == ch) {
						cnt++;	
					}
				}
				System.out.println("There are " + cnt + " " + ch + "'s in the text.");
				break;
			}
			else{
				System.out.println("You must enter a single letter.");
			}
		}
		scan.close();
	}
}
