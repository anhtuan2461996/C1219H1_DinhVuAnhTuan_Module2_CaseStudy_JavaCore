package Commons;

import Models.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import javafx.scene.layout.ColumnConstraints;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

import static Commons.FunWriteAndReadFileCSV.*;
import static Controllers.MainController.backMainMenu;

public class FuncGeneric {
    public enum EnlityType{
        VILLA,
        HOUSE,
        ROOM,
        CUSTOMER,
        EMPLOYEE
    }
    public static<E> void displayList(ArrayList<E> list) {
        int i =1;
        System.out.println("--------List------------");
        for (E item : list){
            System.out.println("NO: " +i);
            if (item instanceof Villa){
                ((Villa)item).showInfor();
            }else if (item instanceof House){
                ((House)item).showInfor();
            }else if (item instanceof Room){
                ((Room)item).showInfor();
            }else if (item instanceof Customer){
                ((Customer)item).showInfor();
            }//else if ()
            i++;
            System.out.println("------------------------");
        }
    }
    public static <E>ArrayList <E> getListFromCSV(EnlityType enlityType){
        String csvPath ="";
        String[]headerRecord;
        switch (enlityType){
            case ROOM:
                csvPath = pathRoom;
                headerRecord = headerRecordRoom;
                break;
            case VILLA:
                csvPath = pathVilla;
                headerRecord = headerRecordVilla;
                break;
            case CUSTOMER:
                csvPath = pathCustomer;
                headerRecord = headerRecordCustomer;
                break;
            case HOUSE:
                csvPath = pathHouse;
                headerRecord = headerRecordHouse;
                break;
            case EMPLOYEE:
                csvPath = pathEmployee;
                headerRecord = headerRecordEmployee;
                break;
            default:
                throw new IllegalCallerException("Unexpected value: "+enlityType);
        }
        Path path = Paths.get(csvPath);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(csvPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        // xu ly setting csv
        ColumnPositionMappingStrategy<E> strategy= new ColumnPositionMappingStrategy<>();
        switch (enlityType){
            case ROOM:
                strategy.setType((Class<? extends E>) Room.class);
                break;
            case VILLA:
                strategy.setType((Class<? extends E>)Villa.class);
                break;
            case CUSTOMER:
                strategy.setType((Class<? extends E>) Customer.class);
                break;
            case HOUSE:
                strategy.setType((Class<? extends E>) House.class);
                break;
            case EMPLOYEE:
                strategy.setType((Class<? extends E>) Employee.class);
                break;
            default:
        }
        strategy.setColumnMapping(headerRecord);
        CsvToBean<E> csvToBean = null;
        //CsvToBean CsvToBeanBuilder
        try {
            csvToBean = new CsvToBeanBuilder<E>(new FileReader(csvPath))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return (ArrayList<E>) csvToBean.parse();
    }
    //ham hien thi ten ko trung nhau
    public static void showAllNameNotDulicate(EnlityType enlityType){
        String csvPath="";
        switch (enlityType){
            case VILLA:
                csvPath = pathVilla;
                break;
            case HOUSE:
                csvPath = pathHouse;
                break;
            case ROOM:
                csvPath = pathRoom;
                break;
        }
        //get file csv
        Path path = Paths.get(csvPath);
        if (!Files.exists(path)){
            System.out.println("----File csv path does not Exists");
            backMainMenu();
        }
        TreeSet<String> treeSet = FunWriteAndReadFileCSV.getAllNameServiceFromCSV(csvPath);
        System.out.println("--------List Name Service Not Duplicate-----");
        for (String str : treeSet){
            System.out.println(str);
            System.out.println("---------------");
        }
        backMainMenu();
    }
}