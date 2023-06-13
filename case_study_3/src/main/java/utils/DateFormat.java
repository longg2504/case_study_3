package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormat {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public static Date parseDate(String strDate) {
        try {
            return (Date) simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid format");
            return null;
        }
    }
    public static String convertDateToString(Date date) {
        return simpleDateFormat.format(date);
    }
}
