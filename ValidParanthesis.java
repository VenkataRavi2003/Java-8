import java.util.Scanner;
import java.util.Stack;
interface ValidPI{
	public abstract boolean isValidParanthesis(String paranthesis);
	public static boolean isMatchedPair(char open , char close){
	return ((open == '[' && close == ']')||(open == '(' && close == ')')||(open == '{' && close == '}'));
	}
}
public class ValidParanthesis{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("\nEnter the parathesis '{','},'[',']','(' ,')' symbols only : ");
			String paranthesis = sc.next();

			 if (!paranthesis.matches("[(){}\\[\\]]*")) {
                             System.out.println("Invalid input! Please enter only valid parentheses.");
                             return;
            }

			ValidPI vpi = (str)->{
				                   Stack<Character> stack = new Stack<Character>();

                                     for (char ch : str.toCharArray()) {
                                   	   
                                   	   if(ch == '(' || ch == '[' || ch == '{'){
                                   	   	 stack.push(ch);

                                   	   }else if(ch == ')' || ch == ']' || ch == '}'){

                                   	   	if(stack.isEmpty())return false;

                                   	   	char top = stack.pop();

                                   	   	if(!ValidPI.isMatchedPair(top,ch)){
                                   	   		return false;
                                   	   	}

                                   	   }
                                   }
                                   return stack.isEmpty();
			                     };

			if(vpi.isValidParanthesis(paranthesis)){
				System.out.println("\n"+paranthesis+" -> Valid parathesis.");
			}else{
				System.out.println("\n"+paranthesis+" -> Not Valid parathesis!!");
			}

			System.out.println("\nAnonymus class name : "+vpi.getClass().getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
