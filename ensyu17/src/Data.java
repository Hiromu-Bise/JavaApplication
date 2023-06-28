import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {

    public static int countWeekDays(String from, String to) throws ParseException {
        final Calendar calendarfrom = getCalendarFor(from);
        final Calendar calendarto = getCalendarFor(from);
        final int MONDAY_CODE = 2;
        final int FRIDAY_CODE = 6;
        //for (){}
        final int dayOfWeekCodefrom = calendarfrom.get(Calendar.DAY_OF_WEEK);
        final int dayOfWeekCodeto = calendarto.get(Calendar.DAY_OF_WEEK);
        //if(MONDAY_CODE <= dayOfWeekCode && dayOfWeekCode <= FRIDAY_CODE ) {

        //} else {

        //}
        return 0;
    }

    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {
        final Date date = Data.validateAndParseDate(yyyymmdd);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date validateAndParseDate(String inputDate) throws ParseException {
        if (!inputDate.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
            throw new ParseException("Invalid date format", 0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);

        return sdf.parse(inputDate);
    }
}
