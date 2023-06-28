package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static Date validateAndParseDate(String inputDate) throws ParseException {
        if (!inputDate.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
            throw new ParseException("Invalid date format", 0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);

        return sdf.parse(inputDate);
    }

    public static int getDaysBetweenDates(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        //(24*60*60*1000)は(時*分*秒*ミリ秒)
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }
}



