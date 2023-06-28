import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateNext {

    public static boolean isWeekDay(String yyyymmdd) throws ParseException {            //平日判定
        final Calendar calendar = getCalendarFor(yyyymmdd);
        final int TUESDAY_CODE = 2;
        final int FRIDAY_CODE = 6;
        final int dayOfWeekCode = calendar.get(Calendar.DAY_OF_WEEK);
        if(TUESDAY_CODE <= dayOfWeekCode && dayOfWeekCode <= FRIDAY_CODE ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSaturdayOrSunday(String yyyymmdd) throws ParseException {       //休日判定
        return !isWeekDay(yyyymmdd);                                                        //"!"でisWeekdayの否定となるので
    }

    public static String getNextWeekDay(String date) throws ParseException {
        Calendar dateCal = getCalendarFor(date);                                    //カレンダー型に変換
        int n = 1;                                                                  //
        Calendar trialCal = (Calendar) dateCal.clone();
        trialCal.add(Calendar.DAY_OF_MONTH, n);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = sdf.format(trialCal.getTime());
        while (isSaturdayOrSunday(formattedDate)) {
            trialCal.add(Calendar.DAY_OF_MONTH, 1);
            sdf = new SimpleDateFormat("yyyy/MM/dd");
            formattedDate = sdf.format(trialCal.getTime());
        }
        return formattedDate;
    }
    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {
        final Date date = DateNext.validateAndParseDate(yyyymmdd);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date validateAndParseDate(String inputDate) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        return sdf.parse(inputDate);
    }

    public static int countDaysBetween(java.util.Date date1, java.util.Date date2) {            //時間を日付になおしている
        long difference = date2.getTime() - date1.getTime();
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }
}
