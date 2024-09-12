import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
interface IOneF{

	public abstract boolean isBothArraysEqual(List<Integer> list1,List<Integer> list2);
}
public class CompareTwoLists{

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int size1,size2;

			while (true) {
				System.out.print("\nEnter size of elements you need to keep in LIST1 && LIST2 : ");
				size1 = sc.nextInt();size2 = sc.nextInt();

				if(size1 > 0 && size2 > 0)break;

				System.out.println("\nSize's must be greater than zero!!");
			}

			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();

			System.out.println("\nEnter the elements into LIST 1 : ");
			takeInput(list1,size1,sc);

			System.out.println("\nEnter the elements into LIST 2 :");
			takeInput(list2,size2,sc);

			sortList(list1);
			sortList(list2);

			System.out.println("\nAfter Sorting LIST 1 :: "+list1);
			System.out.println("\nAfter Sorting LIST 2 :: "+list2);

			IOneF i1 = (l1,l2) -> {
                                    if(l1.size() != l2.size())return false;

                                    for(Integer item : l1){

                                    	if(!l2.contains(item))
                                    		return false;
                                    }

                                    return true;
			                     };

			if(i1.isBothArraysEqual(list1,list2)){
				System.out.println("\nBoth Lists contains same elements.");
			}else{
				System.out.println("\nBoth Lists doesn't contain same elements!!");
			}

		}catch (Exception e) {
			System.out.println("\nException Occured :: "+e.getMessage());
		}
	}
	public static void takeInput(List<Integer> list,int size,Scanner sc){
		int i = 0;
		while(i < size){

			int element = getValidInput(sc);
			list.add(element);
			++i;
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
	public static void sortList(List<Integer> list){

		for (int i = 0 ; i < list.size() - 1; ++i) {
			
			int min = i;

			for (int j = i + 1 ; j < list.size() ; ++j) {
				
				if(list.get(j) < list.get(min)){
					min = j;
				}
			}

			int temp = list.get(min);
			list.set(min , list.get(i));
			list.set(i,temp);
		}
	}
}