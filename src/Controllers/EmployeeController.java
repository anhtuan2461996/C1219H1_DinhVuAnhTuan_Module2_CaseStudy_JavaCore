package Controllers;

import Commons.FuncGeneric;
import Commons.ScannerUtils;
import Data.Resume;
import Models.Employee;

import java.util.*;

import static Controllers.MainController.backMainMenu;

public class EmployeeController {
    public static void showInformationOfEmployee(){
        ArrayList<Employee> employeeList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.EMPLOYEE);
        Map<String, Employee> map = new HashMap<>();
        for (Employee employee: employeeList){
            map.put(employee.getId(),employee);
        }
        displayMap(map);
        backMainMenu();
    }

    public static void displayMap(Map<String, Employee> map) {
        for (Map.Entry m : map.entrySet()){
            System.out.println("key: " +m.getKey() + "\n"+ m.getValue().toString());
        }
    }
    public static void findEmloyeeFromResume(){
        Stack<Employee> employeeStack = Resume.getAllEmployee();
        System.out.println("Nhap key cua employee: ");
        String inputSearch = ScannerUtils.scanner.nextLine();
        try {
            while (true){
                boolean foundById = employeeStack.peek().getId().contains(inputSearch);
                if (!foundById){
                    employeeStack.pop();
                }else {
                    System.out.println("-----Founded employee below: ");
                    System.out.println(employeeStack.peek().toString());
                    break;
                }
            }
        }catch (EmptyStackException ex){
            System.out.println("key invalid, please try again");
            findEmloyeeFromResume();
        }
        backMainMenu();
    }

}
