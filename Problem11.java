


class PalindromeChecker{
	private static boolean flag;
	private static int len;
	private static int num1,num2;
	
	public static void check(int val) {
		len = (int)(Math.log10(val)+1);
		num1 = val;	num2 = val;
		flag = true;
		for(int i = 0; i < len/2; i++) {
			if( num1/(int)(Math.pow(10, len-1-i)) == num2%(int)(Math.pow(10, 1))) {
				flag = true;
				num1 = num1%(int)(Math.pow(10, len-i-1));
				num2 = num2/(int)(Math.pow(10, 1));
			}
			else {
				flag = false;
				break;
			}
		}
		
		if(flag == true) {
			System.out.println(val + " is a palindrome.");		
		}
		else {
			System.out.println(val + " is not a palindrome.");
		}
	}
	public static void check(String str) {
		len = str.length();
		flag = true;
		for(int i = 0; i < len/2; i++) {
			if(str.charAt(i) == str.charAt(len-i-1)) {
				flag = true;
			}
			else {
				flag = false;
				break;
			}
		}
		if(flag == true) {
			System.out.println(str + " is a palindrome.");		
		}
		else {
			System.out.println( str + " is not a palindrome.");
		}
	}
	
}


public class Problem11 {
	 public static void main(String[] args) {
		 PalindromeChecker.check("abcde");
		 PalindromeChecker.check("abcba");
		 PalindromeChecker.check(1234);
		 PalindromeChecker.check(12321);
	}
}