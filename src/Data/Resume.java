package Data;

import Commons.FuncGeneric;
import Models.Employee;

import java.util.ArrayList;
import java.util.Stack;

public class Resume {
   public  Resume(){
   }
   public static Stack<Employee> getAllEmployee(){
       Stack<Employee>employeeList = new Stack<Employee>();
       ArrayList <Employee> employeeArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.EMPLOYEE);
       for (Employee employee : employeeArrayList){
           employeeList.push(employee);
       }
       return employeeList;
   }
   //1.56
}
