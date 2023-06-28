import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
    String name;
    String deadLineDate;
    public Task(String name, String deadLineDate) {
        this.name = name;
        this.deadLineDate = deadLineDate;
    }

    public static boolean isExpired(String today) throws ParseException {
        Task bentou = new Task("弁当", "2023/06/09");
         Calendar bentouC = getCalendarFor(bentou.deadLineDate);
         Calendar toDayC = getCalendarFor(today);
         int ans = Task.countDaysBetween(toDayC.getTime(), bentouC.getTime());
         if (0 <= ans) {
             return true;
         } else {
             return false;
         }
    }

    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {         //カレンダー型変換
        final Date date = Task.validateAndParseDate(yyyymmdd);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date validateAndParseDate(String inputDate) throws ParseException {       //フォーマット変換
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        return sdf.parse(inputDate);
    }

    public static int countDaysBetween(Date date1, Date date2) {            //ミリ秒から日に変換
        long difference = date2.getTime() - date1.getTime();
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }
}