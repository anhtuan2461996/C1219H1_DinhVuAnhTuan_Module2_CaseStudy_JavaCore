package Controllers;

import Commons.FunWriteAndReadFileCSV;
import Commons.FuncGeneric;
import Commons.FuncValidation;
import Commons.ScannerUtils;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.ArrayList;
import java.util.Arrays;

import static Commons.FuncGeneric.displayList;
import static Commons.FuncGeneric.showAllNameNotDulicate;
import static Controllers.MainController.*;


public class ServicesController {
    public static final String ENTER_SERVICE_ID ="Nhap ID dich vu:";
    public static final String INVALID_SERVICE_ID ="ID dich vu dinh kien kieu SVXX-YYYY";
    public static final String ENTER_SERVICE_NAME = "Nhap ten dich vu: ";
    public static final String INVALID_SERVICE_NAME ="Chu cai dau viet hoa, chu cai sau viet thuong: ";
    public static final String ENTER_AREA_USED="Nhap dien tich ho boi:";
    public static final String INVALID_AREA_USED="Dien tich ho boi phai la so thuc lon hon 30m2: ";
    public static final String ENTER_RENTAL_COST="Nhap chi phi thue: ";
    public static final String INVALID_RENTAL_COST="Chi phi thue la so duong:";
    public static final String ENTER_MAX_NUMBER_OF_PEOPLE="Nhap vao so luong nguoi thue: ";
    public static final String INVALID_MAX_PEOPLE="So luong nguoi thue >0 va <20";
    public static final String ENTER_RENT_TYPE="Nhap kieu thue: ";
    public static final String INVALID_RENT_TYPE="Chu cai dau viet hoa, chu cai sau viet thuong: ";
    public static final String ENTER_ROOM_STANDARD = "Nhập tiêu chuẩn phòng";
    public static final String INVALID_ROOM_STANDARD = "Chữ cái đầu viết hoa, các chữ sau viết thường";
    public static final String ENTER_AREA_POOL = "Nhập diện tích hò bơi";
    public static final String INVALID_AREA_POOL = "Diện tích hồ bơi phải là số thực lớn hơn 30m2";
    public static final String ENTER_NUMBER_OF_FLOOR = "Nhập số tầng";
    public static final String INVALID_NUMBER_OF_FLOOR = "Số tầng phải là số nguyên dương";
    public static final String ENTER_FREE_SERVICE = "Nhập dịch vụ đi kèm";
    public static final String INVALID_FREE_SERVICE = "Dịch vụ đi kèm phải là các giá trị: massage, karaoke, food, drink, car";

    public static void addNewServices() {
        displayMenuAddNewService();
        processMenuAddNewService();
    }
    public static void processMenuAddNewService(){
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                backMainMenu();
                break;
            case "5":
                System.exit(0);
            default:
                break;
        }
    }
    private static Services addNewServices(Services services){
        //Set Service ID
        services.setId(FuncValidation.getValidation( ENTER_SERVICE_ID,INVALID_SERVICE_ID));

        //set Service name
        services.setServicesName(FuncValidation.getValidName(ENTER_SERVICE_NAME,INVALID_SERVICE_NAME));

        //set Area Used
        services.setAreaUsed(FuncValidation.getValidNumberDouble(ENTER_AREA_USED,INVALID_AREA_USED,30.0));

        //set Rental Cost
        services.setRentCosts(FuncValidation.getValidNumberDouble(ENTER_RENTAL_COST,INVALID_RENTAL_COST,0.0));

        //set Max Number Of People
        services.setMaxNumberOfPeople(FuncValidation.getValidNumberInterger(ENTER_MAX_NUMBER_OF_PEOPLE,INVALID_MAX_PEOPLE,0,20));

        //set rent type
        services.setRentType(FuncValidation.getValidName(ENTER_RENT_TYPE,INVALID_RENT_TYPE));

        return services;
    }
    private static void addNewRoom() {
        Services room = new Room();
        room = addNewServices(room);

        System.out.println("Enter Free Services: ");
        ((Room)room).setFreeServices(FuncValidation.getValidation(ENTER_SERVICE_NAME,INVALID_SERVICE_NAME));
        //get list Villa from CSV
        ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.ROOM);
        //add villa to list
        roomList.add((Room) room);
        //write to CSV
        FunWriteAndReadFileCSV.writeRoomToFileCsv(roomList);
        System.out.println("---Add Room------: " + room.getServicesName()+" Successfully");
        backMainMenu();
    }

    private static void addNewHouse() {
        Services house = new House();
        house = addNewServices(house);

        //Enter Room Standard
        ((House)house).setRoomStandard(FuncValidation.getValidName(ENTER_SERVICE_NAME,INVALID_SERVICE_NAME));

        //Enter corvenient Description
        System.out.println("Enter corvenient Description: ");
        ((House)house).setConvenientDescription(ScannerUtils.scanner.nextLine());

        //Enter number of floors
        ((House)house).setMaxNumberOfPloors(FuncValidation.getValidNumberInterger(ENTER_NUMBER_OF_FLOOR,INVALID_NUMBER_OF_FLOOR,0));

        //get list Villa from CSV
        ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.HOUSE);
        //add villa to list
        houseList.add((House) house);
        //write to CSV
        FunWriteAndReadFileCSV.writeHouseToFileCsv(houseList);
        
        System.out.println("---Add House------: " + house.getServicesName()+" Successfully");
        backMainMenu();
    }

    private static void addNewVilla() {
        Services villa = new Villa();
        villa = addNewServices(villa);

        //Enter Room Standard getValidation
        ((Villa)villa).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD,INVALID_ROOM_STANDARD));

        //System.out.println("Liner corvenient Description: ");
        ((Villa)villa).setConvenientDescription(ScannerUtils.scanner.nextLine());

        //System.out.println("Enter Area Pool: ");
        ((Villa)villa).setAreaPool(FuncValidation.getValidNumberDouble(ENTER_AREA_POOL,INVALID_AREA_POOL,30.0));

        //System.out.println("Enter number of floors: ");
        ((Villa)villa).setMaxNumberOfPloors(FuncValidation.getValidNumberInterger(ENTER_NUMBER_OF_FLOOR,INVALID_NUMBER_OF_FLOOR,0));
        //get list Villa from CSV
        ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.VILLA);
        //add villa to list
        villaList.add((Villa)villa);
        //write to CSV
        FunWriteAndReadFileCSV.writeVillaToFileCsv(villaList);
        System.out.println("---Add villa: " + villa.getServicesName()+" Successfully");
        backMainMenu();
    }

    public static void showServices() {
        displayMenuShowService();
        processMenuShowService();
    }

    private static void processMenuShowService() {
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                showVilla();
                break;
            case "2":
                showHouse();
                break;
            case "3":
                showRoom();
                break;
            case "4":
                showAllNameVilla();
                break;
            case "5":
                showAllNameHouse();
                break;
            case "6":
                showAllNameRoom();
                break;
            case "7":
                processMain();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("nhap sai , tro lai menu");
                break;
        }
    }

    private static void showAllNameRoom() {
        showAllNameNotDulicate(FuncGeneric.EnlityType.ROOM);
    }

    private static void showAllNameHouse() {
        showAllNameNotDulicate(FuncGeneric.EnlityType.HOUSE);
    }

    private static void showAllNameVilla() {
        showAllNameNotDulicate(FuncGeneric.EnlityType.VILLA);
    }

    private static void showRoom() {
        ArrayList<Room>roomList =FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.ROOM);
        displayList(roomList);
        backMainMenu();
    }

    private static void showHouse() {
        ArrayList<House>houseList =FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.HOUSE);
        displayList(houseList);
        backMainMenu();
    }

    private static void showVilla() {
        ArrayList<Villa>villaList =FuncGeneric.getListFromCSV(FuncGeneric.EnlityType.VILLA);
        displayList(villaList);
        backMainMenu();
    }



    private static void displayMenuShowService() {
        System.out.println("--------Show Server Menu-----------");
        System.out.println("1.Show all Villa"+
                "\n2.Show all House"+
                "\n3.Show all Room"+
                "\n4.Show All Name Villa Not Duplicate"+
                "\n5.Show All Name House Not Duplicate"+
                "\n6.Show All Name Name Not Duplicate"+
                "\n7.Back to menu"+
                "\n8.Exit");
    }
}
