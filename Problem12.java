
class SubsequenceChecker{
	private static int index;
	private static int[] cnt;
	public static void check(String str1, String str2) {
		index = 0;
		cnt = new int[str2.length()];
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i) == str2.charAt(index)) {
				cnt[index] = i;
				index++;
			}
		}		
		if(cnt.length == index) {
			System.out.println(str2 + " is a subsequence of " + str1);
			for(int j=0; j<str2.length(); j++) {
				System.out.print(cnt[j] + " ");
			}
			System.out.println();
		}
		else {
			System.out.println(str2 + " is not a subsequence of " + str1);
		}
	}
}

public class Problem12 {
	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}
