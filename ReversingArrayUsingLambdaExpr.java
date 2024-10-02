import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
interface IOneF{
	public abstract void reverseArray(int arr[]);
}
public class ReversingArrayUsingLambdaExpr{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("\nEnter the size of array : ");
			int size;
			while(true){
				size = sc.nextInt();
				if(size > 0)break;
				System.out.println("\n"+size+" -> size must be greater than zero!!");
			}
			int arr[] = new int[size];

			System.out.println("\nEnter the elements : ");
			takeInput(arr,sc);

			System.out.println("\nBefore Reversing : \n"+Arrays.toString(arr));

			IOneF if1 = (a) -> {
				                    int i = 0 , j = a.length - 1;

				                     while (i < j) {
				                    	
				                    	int temp = a[i];
				                    	a[i] = a[j];
				                    	a[j] = temp;

				                    	++i;
				                    	--j;

				                    }
			                     };
		    if1.reverseArray(arr);

		    System.out.println("\nAfter reversing : \n"+Arrays.toString(arr));
		}catch (Exception e) {
			System.out.println("\nException Occured :: "+e.getMessage());
		}
	}
	public static void takeInput(int arr[],Scanner sc){
		for (int i = 0 ; i < arr.length ; ++i) {
			arr[i] = getValidInput(sc);
		}
	}
	public static int getValidInput(Scanner sc){
		while (true) {
			try{
				return sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\nInvalid input!please enter valid integer as input.");
				sc.next();
			}
		}
	}
}