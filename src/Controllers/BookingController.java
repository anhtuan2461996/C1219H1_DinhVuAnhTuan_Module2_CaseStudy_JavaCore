package Controllers;

import Commons.FunWriteAndReadFileCSV;
import Commons.FuncGeneric;
import Commons.ScannerUtils;
import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Commons.FuncGeneric.displayList;
import static Commons.Menu.displayMenuBooking;
import static Commons.Menu.displayMenuBookingMovieTicket4D;
import static Controllers.MainController.backMainMenu;

public class BookingController {
    private  static Queue<Customer> customerQueueBookingTicket = new LinkedList<Customer>();
    //add new booking
    public static void addNewBooking(){
        ArrayList<Customer> customeryList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.CUSTOMER);
        displayList(customeryList);
        System.out.println("--Chose one customer to booking--");
        Customer customer = new Customer();
        customer = customeryList.get(Integer.parseInt(ScannerUtils.scanner.nextLine())-1);
        displayMenuBooking();
        processMenuBooking(customer);
        //get list customer from CSV
        ArrayList<Customer> listBooking = FunWriteAndReadFileCSV.getBookingFromCSV();
        //add customer to list
        listBooking.add(customer);
        //write to CSV
        FunWriteAndReadFileCSV.writeBookingToFileCsv(listBooking);
        System.out.println("--- Add Booking for: "+customer.getFullName()+" successfully !!!");
        //backMainMenu;
    }

    private static void processMenuBooking(Customer customer) {
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                ArrayList<Villa> villayList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.VILLA);
                displayList(villayList);
                System.out.println("---Choose Villa Booking");
                Villa villa = villayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine())-1);
                customer.setServices(villa);
                break;
            case "2":
                ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.HOUSE);
                displayList(houseList);
                System.out.println("---Choose House Booking");
                House house = houseList.get(Integer.parseInt(ScannerUtils.scanner.nextLine())-1);
                customer.setServices(house);
                break;
            case "3":
                ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.ROOM);
                displayList(roomList);
                System.out.println("---Choose Room Booking");
                Room room = roomList.get(Integer.parseInt(ScannerUtils.scanner.nextLine())-1);
                customer.setServices(room);
                break;
            default:
                break;
        }
    }
    public static void bookingMovieTicket4D(){
        displayMenuBookingMovieTicket4D();
        processMenuBookingMovieTicket4D();
    }

    private static void processMenuBookingMovieTicket4D() {
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                addBookingMovieTicket4D();
                break;
            case "2":
                showBookingMovieTicket();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Error!!! backing to menu");
                backMainMenu();
        }
    }

    private static void showBookingMovieTicket() {
        int i = 1;
        System.out.println("--------List-------------");
        for (Customer customer: customerQueueBookingTicket){
            System.out.println("No: " +i);
            customer.showInfor();
            i++;
            System.out.println("------------------------");
        }
        backMainMenu();
    }

    private static void addBookingMovieTicket4D() {
        //lua chon customer booking ticket
        try {
            ArrayList<Customer>customerList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.CUSTOMER);
            displayList(customerList);
            System.out.println("---Chose customer want booking: ----");
            Customer customer = customerList.get((Integer.parseInt(ScannerUtils.scanner.nextLine())-1));
            customerQueueBookingTicket.add(customer);
            System.out.println("---Add Booking for: " + customer.getFullName() + " successfylly!!!");
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Customer to booking movie ticket 4D not exist!!! Try again");
            addBookingMovieTicket4D();
        }
        backMainMenu();
    }
}
//task 7 3:29