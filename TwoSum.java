import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
interface TwoSumFI{
	public abstract List<Integer> findTwoSum(List<Integer> list,int targetSum);

	public static int getValidInput(Scanner sc){
		while (true) {
			try{
				return sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\nInvalid Input!Please Enter Valid Input.");
				sc.next();
			}
		}
	}

	public static void printList(List<Integer> list){
		for (Integer item : list) {
			System.out.print(item+" ");
		}
	}

	public static void takeInput(List<Integer> list,Scanner sc,int size){
		int i=0;
		while (i++ < size) {
			list.add(getValidInput(sc));
		}
	}

}
public class TwoSum{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){

			System.out.print("\nEnter the size of elements you need to keep in List : ");
			int size;

			while (true) {

				size = TwoSumFI.getValidInput(sc);
				if(size > 0){
					break;
				}else{
					System.out.println("\n"+size+" -> size must be greater than zero!!");
				}
			}

			List<Integer> list = new ArrayList<Integer>();

			System.out.println("\nEnter the elements into LIST : ");
			TwoSumFI.takeInput(list,sc,size);

			System.out.println("\nResulted List : \n");
			TwoSumFI.printList(list);

			System.out.print("\nEnter the target sum : ");
			int targetSum = TwoSumFI.getValidInput(sc);

			TwoSumFI tsfi = (l,ts) -> {
                                         List<Integer> twoSum = new ArrayList<Integer>(2);
                                         twoSum.add(-1);twoSum.add(-1);

                                         for (int i=0;i<l.size();++i) {

                                         	for (int j=i+1;j<l.size(); ++j) {

                                         		if((l.get(i)+l.get(j)) == ts){
                                         			twoSum.set(0,i);
                                         			twoSum.set(1,j);
                                         			return twoSum;
                                         		}
                                         	}
                                         }

                                         return twoSum;

			                          };

			List<Integer> res = tsfi.findTwoSum(list,targetSum);

			if(res.get(0) != -1 && list.get(1) != -1){
				System.out.println("\n"+res.get(0)+" & "+res.get(1)+" : Indicies sums equals to target sum -> "+targetSum);
			}else{
				System.out.println("\nNo Two Indicies equals to target sum");
			}


		}catch (Exception e) {
			System.out.println("\nException Occured : "+e.getMessage());
		}
	}
}