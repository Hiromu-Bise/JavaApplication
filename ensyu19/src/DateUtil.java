import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static boolean isWeekDay(String yyyymmdd) throws ParseException {        //平日判定
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

    public static boolean isSaturdayOrSunday(String yyyymmdd) throws ParseException {       //土日判定
        return !isWeekDay(yyyymmdd);
    }

    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {         //カレンダー型変換
        final Date date = DateUtil.validateAndParseDate(yyyymmdd);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date validateAndParseDate(String inputDate) throws ParseException {       //フォーマット変換
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        return sdf.parse(inputDate);
    }

    public static int countWorkingDays(String from, String to) throws ParseException {      //指定範囲内の平日のカウント
        String[] daysStrings = getDaysStrBetween(from, to);
        int count = 0;
        //toの日付は含めないように変更した為、daysStrings.length - 1までloop
        for (int i = 0; i < daysStrings.length - 1; i++) {
            if(!isSaturdayOrSunday(daysStrings[i]))
                count++;
        }
        return count;
    }

    public static String[] getDaysStrBetween(String from, String to) throws ParseException{     //指定範囲内の日数のカウント
        Calendar fromC = getCalendarFor(from);
        Calendar toC = getCalendarFor(to);
        int howManyDays = DateUtil.countDaysBetween(fromC.getTime(), toC.getTime()) + 1;
        String[] strings = new String[howManyDays];
        int n = 0;
        while (n != howManyDays) {
            Calendar tmp = (Calendar) fromC.clone();
            tmp.add(Calendar.DAY_OF_MONTH, n);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String formattedDate = sdf.format(tmp.getTime());
            strings[n] = formattedDate;
            n++;
        }
        return strings;
    }

    public static int countDaysBetween(Date date1, Date date2) {            //ミリ秒から日に変換
        long difference = date2.getTime() - date1.getTime();
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }

    public static String getNextWorkingDayOf(String date) throws ParseException {       //次の平日を求める
        Calendar dateCal = getCalendarFor(date);
        int n = 1;
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

}