package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee{
    int eid;
    String name;
    public Employee(int eid,String name){
        this.eid = eid;
        this.name = name;
    }
    public String toString(){  
        return eid +" -> "+name;
    }
}
public class SortingEmployees {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(161,"ravi"));
        list.add(new Employee(121,"chandu"));
        list.add(new Employee(131,"venky"));
        list.add(new Employee(151,"madhu"));
        list.add(new Employee(111,"anitha"));
        System.out.println("\nBefore Sorting : \n"+list);
        Collections.sort(list,(e1,e2) -> (e1.eid < e2.eid) ? -1 : (e1.eid > e2.eid) ? 1 : 0);
        System.out.println("\nAfter Sorting : \n"+list);
    }
}