package Commons;

import java.util.Scanner;

public class Menu {
    public static void displayMainMenu()  {
        System.out.println("-------Main Menu---------");
        System.out.println(
                "1.Add New Services"+
                "\n2.Show Services"+
                "\n3.Add New Customer"+
                "\n4.Show Information of Customer"+
                "\n5.Add New Booking"+
                "\n6.Show Information of Employee"+
                "\n7.Booking Movie Ticket 4D"+
                "\n8.Find Employee"+
                "\n9.Exit"
        );
    }
    public static void displayMenuAddSevices()  {
        System.out.println("-------Add new Sevices Menu---------");
        System.out.println(
                "1.Add New Villa"+
                        "\n2.Add New House"+
                        "\n3.Add New Room"+
                        "\n4.Back to menu"+
                        "\n5.Exit"
        );
    }
    public static void displayMainBackToMain(){
        System.out.println("--------------Enter-------------");
        ScannerUtils.scanner.nextLine();
    }
    public static void displayMenuBooking() {
        System.out.println("1.Booking Vilal."+
                "\n2.Booking Hour."+
                "\n3.Booking Room");
        System.out.println("---Choose Services Booking");
    }
    public static void displayMenuBookingMovieTicket4D(){
        System.out.println("--------Booking Movie Ticket 4D Menu------");
        System.out.println("1.Booking movie ticket " +
                "\n2.Show customer booking movie ticket"+
                "\n3.Exit");
        System.out.println("----Please select one function below: ");
    }

}
