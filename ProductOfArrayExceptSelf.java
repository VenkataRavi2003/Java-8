import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
@FunctionalInterface
interface IOneF{
	int[] findProductOfArrayExceptSelf(int arr[]);
}
public class ProductOfArrayExceptSelf{
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

			                     int res[] = new int[a.length];
			                     int index = 0;
				                 for (int i = 0; i < a.length ; ++i) {
				                    
				                     int prod = 1;

				                     for (int j = 0 ; j < a.length ; ++j) {
				                     	
				                     	if(i == j) continue;

				                     	prod *= a[j];
				                     }

				                     res[index++] = prod;
				                 }

				                 return res;
			                  };

			int res[] = i1.findProductOfArrayExceptSelf(arr);

			System.out.println("\nResult : "+Arrays.toString(res));

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