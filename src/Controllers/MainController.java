package Controllers;

import Commons.ScannerUtils;

import java.util.Scanner;

import static Commons.Menu.displayMainBackToMain;
import static Commons.Menu.displayMainMenu;
import static Controllers.BookingController.addNewBooking;
import static Controllers.BookingController.bookingMovieTicket4D;
import static Controllers.CustomerController.addNewCustomer;
import static Controllers.CustomerController.showInfomationCustomer;
import static Controllers.EmployeeController.findEmloyeeFromResume;
import static Controllers.EmployeeController.showInformationOfEmployee;
import static Controllers.ServicesController.addNewServices;
import static Controllers.ServicesController.showServices;

public class MainController {
    public static void processMain(){
        try {
            displayMainMenu();
            processMenuMain();
        }catch (Exception E){
            backMainMenu();
        }
    }

    private static void processMenuMain() {
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInfomationCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInformationOfEmployee();
                break;
            case "7":
                bookingMovieTicket4D();
                break;
            case "8":
                findEmloyeeFromResume();
                break;
            case "9":
                System.exit(0);
                break;
            default:
                System.out.println("Faill");
                backMainMenu();
        }
    }
    public static void displayMenuAddNewService(){
        System.out.println("------Add New Sevrvice Menu------------");
        System.out.println(
                "1.Add New Villa: "+
                "\n2.Add New House: "+
                "\n3.Add New Room: "+
                "\n4.Back to menu: "+
                "\n5.Exit: "
        );
    }
    public static void backMainMenu() {
        displayMainBackToMain();
        processMain();
    }
}
