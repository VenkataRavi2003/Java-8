import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
interface IOne{

	public abstract boolean isBothAnagrams(String s1,String s2);

}
public class Anagrams{
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){

			System.out.print("\nEnter 1st string : ");
			String s1 = sc.nextLine();

			System.out.print("\nEnter 2nd string : ");
			String s2 = sc.nextLine();

			IOne i1 = (str1,str2) ->  {

				                         if(str1.length() != str2.length())return false;

				                         char ch1[] = str1.toLowerCase().toCharArray();
				                         char ch2[] = str2.toLowerCase().toCharArray();

				                         Arrays.sort(ch1);
				                         Arrays.sort(ch2);

				                         return Arrays.equals(ch1,ch2);

		                              };

		    if(i1.isBothAnagrams(s1,s2)){
		    	System.out.println("\n"+s1+" && "+s2+" -> Are Anagrams.");
		    }else {
		    	System.out.println("\n"+s1+" && "+s2+" -> Not Anagrams!!");
		    }
		    
		}catch (Exception e) {
			System.out.println("\nException Occured :: "+e.getMessage());
		}
	}
}
