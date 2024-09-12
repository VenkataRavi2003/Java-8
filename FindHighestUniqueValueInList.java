import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
interface IOne{

	public abstract int findHighestUniqueElement(List<Integer> list);

}
public class FindHighestUniqueValueInList{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){

			int size;

			while (true) {
				System.out.print("\nEnter the size of elements you need to keep in LIST : ");
				size = sc.nextInt();
				if(size > 0)break;
				System.out.println("\n"+size+" -> size must be greater than zero!!");
			}

			List<Integer> list = new ArrayList<Integer>();
			System.out.println("\nEnter the elements : ");
			takeInput(list,size,sc);

			System.out.println("\nResulted List :: "+list);

			IOne i1 = (inputList) -> {
				              for (int i = 0; i < inputList.size() - 1 ; ++i) {
				              	
				              	   for (int j = i + 1 ; j < inputList.size() ; ++j) {
				              	   	    
				              	   	    if(list.get(i).equals(list.get(j))){

				              	   	    	list.set(i,-1);
				              	   	    	list.set(j,-1);
				              	   	    }
				              	   } 
				              }

				              Collections.sort(list);

				              if(list.get(list.size() - 1) == -1){
				              	return -1;
				              }

				              return list.get(list.size() - 1);
			                };

			 int highestUnique = i1.findHighestUniqueElement(list);
			System.out.println("\nHighest Unique Element : "+highestUnique);

		}catch (Exception e) {
			System.out.println("\nException Occured :: "+e.getMessage());
		}
	}
	public static void takeInput(List<Integer> list,int size,Scanner sc){
		for (int i = 0 ; i < size ; ++i) {
			int element = getValidInput(sc);
			list.add(element);
		}
	}
	public static int getValidInput(Scanner sc){

		while(true){
			try{
				return sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\nInvalid input!!please enter valid integer as input.");
				sc.next();
			}
		}
	}
}