package Commons;

import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.TreeSet;

public class FunWriteAndReadFileCSV {
    public static final char DEFAULT_SEPARATOR=',';
    public static final char DEFAULT_QUOTE='"';
    public static final int NUM_OF_LINE_SKIP=1;
    //path file villa
    public static final String pathVilla="src/Data/Villa.csv";
    public static final String pathRoom="src/Data/Room.csv";
    public static final String pathHouse="src/Data/House.csv";
    public static final String pathCustomer="src/Data/Customer.csv";
    public static final String pathBooking="src/Data/Booking.csv";
    public static final String pathEmployee="src/Data/Employee.csv";
    //hearder Villa.csv
    public static String[]headerRecordVilla = new String[]{"id","servicesName","areaUsed","rentalCost","maxNumberOfPeople","rentType","roomStandard","converientDescription","areaPool","numberOfFloors"};
    public static String[]headerRecordRoom = new String[]{"id","servicesName","areaUsed","rentalCost","maxNumberOfPeople","rentType","FreeService"};
    public static String[]headerRecordHouse = new String[]{"id","servicesName","areaUsed","rentalCost","maxNumberOfPeople","rentType","roomStandard","converientDescription","numberOfFloors"};
    public static String[]headerRecordCustomer = new String[]{"fullName","birthday","gender","idCard","phone","email","customerType","address"};
    public static String[]headerRecondBooking = new String[]{"fullName", "birthday", "gender", "idCard", "phone", "email", "customerType", "address","id","serviceName","areaUser", "rentalCosts","maxNumberOfPeople","rentType"};
    public static String[]headerRecordEmployee = new String[]{"id","fullName", "age", "address"};
    //funcition write Villa to File Csv
    public static void writeVillaToFileCsv(ArrayList<Villa> arrayList) {
        try (Writer writer = new FileWriter(pathVilla);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);){
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa: arrayList){
                csvWriter.writeNext(new String[]{
                        villa.getId(),villa.getServicesName(),String.valueOf(villa.getAreaUsed()),String.valueOf(villa.getRentCosts()),String.valueOf(villa.getMaxNumberOfPeople()),
                        villa.getRentType(),villa.getRoomStandard(),villa.getConvenientDescription(),String.valueOf(villa.getAreaPool()),String.valueOf(villa.getMaxNumberOfPloors())
                });
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeHouseToFileCsv(ArrayList<House> houseList) {
        try (Writer writer = new FileWriter(pathHouse);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END);){
            csvWriter.writeNext(headerRecordHouse);
            for (House house: houseList)
                csvWriter.writeNext(new String[]{
                        house.getId(), house.getServicesName(), String.valueOf(house.getAreaUsed()), String.valueOf(house.getRentCosts()), String.valueOf(house.getMaxNumberOfPeople()),
                        house.getRentType(), house.getRoomStandard(), house.getConvenientDescription(), String.valueOf(house.getMaxNumberOfPloors())
                });
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeRoomToFileCsv(ArrayList<Room> roomList) {
        try (Writer writer = new FileWriter(pathRoom);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END);){
            csvWriter.writeNext(headerRecordRoom);
            for (Room room: roomList)
                csvWriter.writeNext(new String[]{
                        room.getId(), room.getServicesName(), String.valueOf(room.getAreaUsed()), String.valueOf(room.getRentCosts()), String.valueOf(room.getMaxNumberOfPeople()),
                        room.getRentType()
                });
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeCustomerToFileCsv(ArrayList<Customer> arrayList)  {
        try (Writer writer = new FileWriter(pathCustomer);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END);){
            //add Header to file
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : arrayList){
                csvWriter.writeNext(new String[]{
                customer.getFullName(),customer.getBirthday(),customer.getGender(),String.valueOf(customer.getIdCard()),
                customer.getPhone(),customer.getEmail(),customer.getCustomerType(),customer.getAddress()
            });
            }
    } catch (IOException e) {
            System.out.println(e.getMessage());
        }
}
    //get list Booking from CSV
    public static ArrayList<Customer> getBookingFromCSV() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try (Reader reader = new FileReader(pathBooking);
             CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] line;
            csvReader.skip(1);
            while ((line = csvReader.readNext()) != null) {
                Customer customer = new Customer();
                Villa villa = new Villa();
                int pos = 0;
                customer.setFullName(line[pos++]);
                customer.setBirthday(line[pos++]);
                customer.setGender(line[pos++]);
                customer.setIdCard(line[pos++]);
                customer.setPhone(line[pos++]);
                customer.setEmail(line[pos++]);
                customer.setAddress(line[pos++]);
                customer.setCustomerType(line[pos++]);

                villa.setId(line[pos++]);
                villa.setServicesName(line[pos++]);
                villa.setAreaUsed(Double.parseDouble(line[pos++]));
                villa.setRentCosts(Double.parseDouble(line[pos++]));
                villa.setMaxNumberOfPeople(Integer.parseInt(line[pos++]));
                villa.setRentType(line[pos++]);
                customer.setServices(villa);
                listCustomer.add(customer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listCustomer;
    }
    public static TreeSet<String> getAllNameServiceFromCSV(String path){
        BufferedReader br =null;
        TreeSet<String> result = new TreeSet<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) !=null){
                if (getNameServiceFromFile(line).equals("servicesName")){
                    continue;
                }
                result.add(getNameServiceFromFile(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br !=null){
                    br.close();
                }
            }catch (IOException crunchifyException){
                crunchifyException.printStackTrace();
            }
        }
//        Mac dinh TreeSet sắp xếp tăng dần, còn giảm dần dùng hàm descendingSet
//        result.descendingSet();
    return result;
    }

    private static String getNameServiceFromFile(String csvLine) {
    String name= "";
    if (csvLine !=null){
        String[] splitData = csvLine.split(",");
        name = splitData[1];
    }
    return name;
    }

    public static void writeBookingToFileCsv(ArrayList<Customer>arrayList)  {
        try (Writer writer = new FileWriter(pathBooking);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.RFC4180_LINE_END);){
            //add Header to file
            csvWriter.writeNext(headerRecondBooking);
            for (Customer customer:arrayList){
                csvWriter.writeNext(new String[]{
                        //Information customer
                        customer.getFullName(),customer.getBirthday(),customer.getGender(),customer.getIdCard(),customer.getPhone(),customer.getEmail(),customer.getCustomerType(),customer.getAddress(),
                        //Information Services
                        customer.getServices().getId(),customer.getServices().getServicesName(),String.valueOf(customer.getServices().getAreaUsed()),String.valueOf(customer.getServices().getRentCosts()),String.valueOf(customer.getServices().getMaxNumberOfPeople()),customer.getServices().getRentType()
                        });
            }
            csvWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

}
