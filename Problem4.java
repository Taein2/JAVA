import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str, word, temp="";
		char[] arr1;
		int cnt = 0;
		char ch;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a text: ");
		str = scan.nextLine();
		arr1 = str.toCharArray();
	
		while(true) {
			System.out.print("Enter a String: ");
			word = scan.nextLine();
			if((!word.isBlank())) {
				ch =  word.charAt(0);
				for(int i = 0; i < arr1.length; i++) {
					if(arr1[i] == ch && ((arr1.length-i) >= word.length())) {
						for(int j=0; j < word.length();j++) {
								temp += arr1[i+j];
						}
						if(temp.equals(word)) {
							cnt++;
						}
					}
					temp = "";
				}
				break;
			}
			else {
				System.out.println("You must enter a string.");
			}
		}
		System.out.println("There are " + cnt + " instances of " + "\"" + word +"\".");
		scan.close();
	}
		
}

