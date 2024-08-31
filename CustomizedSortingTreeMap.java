package java8;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class CustomizedSortingTreeMap {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int size;
            while(true){
                System.out.print("\nEnter the size of elements you need to keep in Map : ");
                size = sc.nextInt();
                if(size > 0){
                    break;
                }
                System.out.println("\n"+size+" -> size must be greater than zero!!");
            }
            Map<Integer,String> map = new TreeMap<>((I1,I2) -> (I1 > I2) ? -1 : (I1 < I2) ? 1 : 0);
            takeInput(map,size,sc);
            
            System.out.println("\nDefault Sorting : \n"+map);
        }catch(Exception e){
            System.out.println("\nException Occured :: "+e.getMessage());
        }
    }
    public static void takeInput(Map<Integer,String> map , int size,Scanner sc){
        for (int i = 0; i < size; i++) {
            System.out.print("\nEnter Key : ");
            int key = sc.nextInt();
            System.out.print("\nEnter Value : ");
            String val = sc.next();
            map.put(key,val);
        }
    }
}
