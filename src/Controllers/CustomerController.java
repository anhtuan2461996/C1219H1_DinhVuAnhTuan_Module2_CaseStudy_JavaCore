package Controllers;

import Commons.FunWriteAndReadFileCSV;
import Commons.FuncGeneric;
import Commons.FuncValidation;
import Commons.ScannerUtils;
import Models.Customer;
import Models.Room;
import Models.SortNameAndYear;

import java.util.ArrayList;

import static Commons.FuncGeneric.displayList;
import static Controllers.MainController.backMainMenu;

public class CustomerController {
    public static final String ENTER_CUSTOMER_NAME ="Nhap ho va ten:";
    public static final String INVALID_CUSTOMER_NAME ="Ho va ten theo dinh dang Dinh Vu Anh Tuan";
    public static final String ENTER_BIRTHDAY ="Nhap ngay sinh:";
    public static final String INVALID_BIRTHDAY ="Ngay sinh kieu dd/MM/yyyy va có năm sinh >1900 và nhỏ hơn ngày hiện tại là 18 năm";
    public static final String ENTER_GENDER ="Nhap gioi tinh:";
    public static final String INVALID_GENDER ="Gioi tinh Male, Female hoặc Unknow";
    public static final String ENTER_ID_CARD ="Nhap ID card:";
    public static final String INVALID_ID_CARD ="ID card theo dinh dang XXX XXX XXX";
    public static final String ENTER_EMAIL ="Nhap gmail:";
    public static final String INVALID_EMAIL ="Gmail theo kieu dinhvuanhtuan@gmail.com";
    //public static final String ENTER_CUSTOMER_NAME ="Nhap ID dich vu:";
    //public static final String INVALID_CUSTOMER_NAME ="ID dich vu dinh kien kieu SVXX-YYYY";

    //add new customer
    public static void addNewCustomer(){
        Customer customer = new Customer();
        //set full name customer
        customer.setFullName(FuncValidation.getValidCustomerName(ENTER_CUSTOMER_NAME,INVALID_CUSTOMER_NAME));
        //set Birthday Customer
        customer.setBirthday(FuncValidation.getValiBirthday(ENTER_BIRTHDAY,INVALID_BIRTHDAY));
        //set gender
        String gender=FuncValidation.getValidGender(ENTER_GENDER,INVALID_GENDER);
        customer.setGender(gender);
        customer.setGender(Character.toUpperCase(gender.charAt(0)) + gender.substring(1,gender.length()).toLowerCase());
        //set ID card customer
        customer.setIdCard(FuncValidation.getVaildIdCard(ENTER_ID_CARD,INVALID_ID_CARD));
        //set phone
        System.out.println("Nhap vao sdt: ");
        customer.setPhone(ScannerUtils.scanner.nextLine());
        //set Email customer
        customer.setEmail(FuncValidation.getVaildGmail(ENTER_EMAIL,INVALID_EMAIL));
        //set Type Customer
        System.out.println("Nhap vao loai khach hang: ");
        customer.setCustomerType(ScannerUtils.scanner.nextLine());
        //set address customer
        System.out.println("Nhap vao dia chi khach hang: ");
        customer.setAddress(ScannerUtils.scanner.nextLine());

        //get list Customer from csv
        ArrayList<Customer> customersList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.CUSTOMER);
        //add customer to list
        customersList.add(customer);
        //write to CSV
        FunWriteAndReadFileCSV.writeCustomerToFileCsv(customersList);
        System.out.println("---Add Room------: " + customer.getFullName()+" Successfully");
        backMainMenu();
    }
    //show informationcustomer
    public static void showInfomationCustomer(){
        ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.CUSTOMER);
        //sap xep thu tu theo ten,neu trung thi sap xep tang dan theo nam sinh
        customerList.sort(new SortNameAndYear());
        displayList(customerList);
        backMainMenu();
    }

}
