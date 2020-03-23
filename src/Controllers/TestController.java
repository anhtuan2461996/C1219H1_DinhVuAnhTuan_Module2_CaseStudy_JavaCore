package Controllers;

import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

public class TestController {
    public static void main(String[] args) {
        Services villa = new Villa("Villa","VL",150,90000,10,"Hour","Vip","Has 2 batroom",80,6);
        villa.showInfor();
        System.out.println("-------------------------------");
        Room room = new Room("Room","RM",250,50,15,"Day","free");
        room.showInfor();
        System.out.println("-------------------------------");
        House house = new House("House","HE",100,75,5,"month","water","Has 1 batroom", 8);
        house.showInfor();
    }
}
