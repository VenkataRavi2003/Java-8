import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
@FunctionalInterface
interface IOneF{
	boolean isContainsDuplicates(int arr[]);
}
public class ContainsDuplicate{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("\nEnter the size of array : ");
			int size;
			while (true) {
				size = getValidInput(sc);
				if(size > 0)break;
				System.out.print("\n"+size+" -> array size must be greater than zero! Try Again : ");
			}
			int arr[] = new int[size];
			System.out.println("\nEnter the elements into array : ");
			takeInput(arr,sc);

			System.out.println("\nResulted Array : "+Arrays.toString(arr));

			IOneF i1 = (a) -> {
				                 for (int i = 0 ; i < a.length ; ++i) {
				                 	
				                 	for (int j = i + 1; j < a.length ; ++j) {
				                 		
				                 		if(arr[i] == arr[j]) return true;
				                 	}
				                 }
				                 return false;
			                  };

			if(i1.isContainsDuplicates(arr)){
				System.out.println("\ntrue : Resulted Array Contains Duplicate Elements.");
			}else{
				System.out.println("\nfalse : Resulted Array Doesn't Contain Duplicates!");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void takeInput(int arr[],Scanner sc){
		int i = 0;
		do{
			arr[i] = getValidInput(sc);
			i++;
		}while(i < arr.length);
	}
	public static int getValidInput(Scanner sc){
		while (true) {
			try{
				return sc.nextInt();
			}catch (Exception e) {
				System.out.print("\nInvalid Input!Please enter valid Integer as input! Try Again : ");
				sc.next();
			}
		}
	}
}