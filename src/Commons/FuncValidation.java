package Commons;

import CustomerException.*;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.lang.ref.Cleaner;
import java.util.Calendar;

public class FuncValidation {
    public static String getValiBirthday;
    private static String parttern="";
    public static String getValidation(Services services,String strDisplay, String errMes){
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidIdSevices(services,result)){
            System.out.println(errMes);
            result = getValidation(services,strDisplay,errMes);
        }
        return result;
    }

    public static String getValidation(String strDisplay, String errMes){
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidIdFreeServices(result)){
            System.out.println(errMes);
            result = getValidation(strDisplay,errMes);
        }
        return result;
    }
    //bieu thuc chinh qui kiem tra free
    private static boolean isValidIdFreeServices(String str) {
        parttern= "^massage|karaoke|food|drink|car";
        return str.matches(parttern);
    }
    //bieu thuc chinh qui kiem tra
    private static boolean isValidIdSevices(Services services, String str) {
            if (services instanceof Villa){
                parttern ="^SVVL-\\d{4}$";
            }else if (services instanceof House){
                parttern ="^SVHO-\\d{4}$";
            }else if (services instanceof Room){
                parttern ="^SVRO-\\d{4}$";
            }
            return str.matches(parttern);
    }

    public static String getValidName(String strDisplay,String errMes){
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidNameSever(result)){
            System.out.println(errMes);
            result = getValidName(strDisplay,errMes);
        }
        return result;
    }
    //bieu thuc chinh qui kiem tra ten
    private static boolean isValidNameSever(String str) {
        //parttern = "^[a-z A-Z]{1,50}$";
        //parttern = "^[A-Z][a-z]+\\/S$";
        parttern = "^(([A-Z][a-z]+\\s{0,1})+)$";
        return str.matches(parttern);
    }

    public static String getValidName(Services services, String strDisplay,String errMes) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidNameSever(result)){
            System.out.println(errMes);
            result = getValidName(strDisplay,errMes);
        }
        return result;
    }

    public static double getValidNumberDouble(String strDisplay, String errMes, Double min) {
        double result =0.0;
        System.out.println(strDisplay);
        try {
            result = Double.parseDouble(ScannerUtils.scanner.nextLine());
            if (min!=null&& result<=min){
                throw new Exception(errMes);
            }
        }catch (Exception e){
            System.out.println(errMes);
            result = getValidNumberDouble(strDisplay,errMes,min);
        }
        return result;
    }
    public static Integer getValidNumberInterger(String strDisplay, String errMes, Integer min) {
        return getValidNumberInterger(strDisplay,errMes,min,null);
    }
    public static Integer getValidNumberInterger(String strDisplay, String errMes, Integer min, Integer max) {
        int result = 0;
        System.out.println(strDisplay);
        try {
            result = Integer.parseInt(ScannerUtils.scanner.nextLine());
            if ( min != null &&result <= min){
                throw new Exception(errMes);
            }else if (max != null&& result>=max){
                throw new Exception(errMes);
            }
        }catch (Exception e){
            System.out.println(errMes);
            result = getValidNumberInterger(strDisplay,errMes,min,max);
        }
        return result;
    }

    public static String getValiBirthday(String strDisplay, String errMes) {
        String result="";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidBirthday(result)){
                throw new BirthdayException(errMes);
            }
            int year = Integer.parseInt(result.substring(6,10));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year<1900||currentYear - year <= 18){
                throw new BirthdayException(errMes);
            }
        }catch (BirthdayException e){
            System.out.println(errMes);
            result = getValiBirthday(strDisplay,errMes);
        }
        return result;
    }
    //bieu thuc chinh qui kiem tra ngay sinh
    private static boolean isValidBirthday(String str) {
        parttern="^([0-2][0-9]|(3)(0-1))(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        return str.matches(parttern);
    }

    public static String getValidGender(String strDisplay, String errMes) {
        String result="";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidGender(result)){
                throw new  GenderException(errMes);
            }
        }catch (GenderException e){
            System.out.println(errMes);
            result = getValidGender(strDisplay,errMes);
        }
        return result;
    }
    //bieu thuc chinh qui kiem tra gioi tinh
    private static boolean isValidGender(String str) {
        parttern="^(?i:Male|Female|Unknow)$";
        return str.matches(parttern);
    }

    public static String getVaildIdCard(String strDisplay, String errMes) {
        String result="";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidIdCard(result)){
                throw new IdCardException(errMes);
            }
        }catch (IdCardException e){
            System.out.println(errMes);
            result = getValidGender(strDisplay,errMes);
        }
        return result;
    }

    private static boolean isValidIdCard(String strDisplay) {
        parttern="^\\d{9}$";
        return strDisplay.matches(parttern);
    }

    public static String getVaildGmail(String strDisplay, String errMes) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidGmail(result)){
                throw new EmailException(errMes);
            }
        }catch (EmailException e){
            System.out.println(errMes);
            result = getVaildGmail(strDisplay,errMes);
        }
        return result;
    }

    private static boolean isValidGmail(String strDisplay) {
        parttern="^[0-9a-z._-]+@g[a-z0-9.-]+\\.[a-z]{2,3}";
        return strDisplay.matches(parttern);
    }

    public static String getValidCustomerName(String strDisplay, String errMes) {
        String result = "";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidNameSever(result)){
                throw new NameException(result);
            }
        }catch (NameException e){
            System.out.println(errMes);
            result = getValidCustomerName(strDisplay,errMes);
        }
        return result;
    }
}
