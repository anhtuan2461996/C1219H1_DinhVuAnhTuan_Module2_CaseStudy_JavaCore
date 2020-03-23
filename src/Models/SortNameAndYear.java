package Models;

import java.util.Comparator;

public class SortNameAndYear implements Comparator<Customer> {
    public int compare(Customer s1,Customer s2){
        int resultCompareName = s1.getFullName().compareTo(s2.getFullName());
        if (resultCompareName ==0){
            return compareYear(s1,s2);
        }
        return resultCompareName;
    }

    private int compareYear(Customer s1, Customer s2) {
        int yearCustomer1 = Integer.parseInt(s1.getBirthday().substring(6,10));
        int yearCustomer2 = Integer.parseInt(s2.getBirthday().substring(6,10));
        if (yearCustomer1 == yearCustomer2){
            return 0;
        }else if (yearCustomer1 > yearCustomer2){
            return 1;
        }else {
            return -1;
        }
    }
}
