package Day9;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
import java.util.Locale;

public class CalendarDemo {
    public static void main(String[] args) {
        //Old API
//        Date date = new Date();
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.setTime(date);

        /*
            Date time formatter
            ZoneId
            java.time
         */

        /*
            Question - Why most of the date classes have private
            constructor
         */

//        String str = "22-12-2021";
//        ZoneId zd = ZoneId.systemDefault();
//        System.out.println(zd.toString());
//        LocalDate localDate = LocalDate.now(zd);
//        System.out.println(localDate);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        //LocalDate time
//        LocalDateTime ins = LocalDateTime.now();
//        String str2 = ins.toString();
//        String[] strs = str2.split("T");
//        for(String str3 : strs){
//            System.out.println(str3);
//        }

        //How do you calcluate elapsed time
        //How do you convert string to date
        //And date into string
        //How do find the day on a given date
//        Locale[] locales = Locale.getAvailableLocales();
//        System.out.println(Arrays.toString(locales));

        //Period
        //Instant
        //Duration

        LocalDate da = LocalDate.of(2022, 11, 19);
        Period period = Period.between(da, LocalDate.now());
        System.out.println(period);
    }
}
