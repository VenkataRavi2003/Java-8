import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
interface IOneF{

	int findSecondMax(List<Integer> list);
}

public class SecondMaximumElementInList{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){

			System.out.print("\nEnter the size of elements you need to keep in LIST : ");
			int size;
			while (true) {
				size = getValidInput(sc);
				if(size > 0)break;
				System.out.print("\n"+size+" : Size must be greater than zero! Try Again : ");
			}

			List<Integer> list = new ArrayList<Integer>();

			System.out.println("\nEnter the elements into LIST : ");
			takeInput(list,size,sc);

			System.out.println("\nResulted LIST : "+list);

			IOneF i1 = (l) -> {
                                 int max = l.get(0) , smax = l.get(0);

                                 for (int i = 1 ; i < l.size() ; ++i) {
                                 	
                                 	if(max < l.get(i)){
                                 		smax = max;
                                 		max = l.get(i);
                                 	}else if(smax < l.get(i) && smax != max){
                                 		smax = l.get(i);
                                 	}
                                 }

                                 return smax;
			                  };

			int secondMax = i1.findSecondMax(list);
			System.out.println("\nSecond Maximum : "+secondMax);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void takeInput(List<Integer> list,int size,Scanner sc){

		for (int i = 0 ; i < size ; ++i) {
			
			list.add(getValidInput(sc));
		}
	}
	public static int getValidInput(Scanner sc){
		while (true) {
			
			try{
				return sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.print("\nInvalid Input!Please Enter Valid Integer As Input : ");
				sc.next();
			}
		}
	}
}