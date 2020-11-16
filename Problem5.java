import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[5];
		int keep[] = new int[5];
		
		int temp;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter exam scores of each student.");
		for(int i=0; i<arr.length; i++) {
			System.out.print("Score of student " + (i+1) +": ");
			arr[i] = scan.nextInt();
		}
		
		for(int i=0; i<arr.length; i++) {
			keep[i] = arr[i];
		}
		for(int j=0; j<arr.length; j++) {
			for(int k=j+1; k < arr.length; k++) {
				if(arr[j] < arr[k]) {
					temp = arr[k];
					arr[k] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int j=0; j<2; j++) {
			for(int k=0; k < keep.length; k++) {
				if(keep[k] == arr[j]){
					System.out.println("The " + (j+1) + "st place is student " + (k+1) + " with "+ arr[j] + "points.");
				}
			}
		}
		
		scan.close();
	}
}
