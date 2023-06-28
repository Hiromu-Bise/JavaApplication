import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class WeekDays {


    public static boolean isWeekDay(String yyyymmdd) throws ParseException {
        final Calendar calendar = getCalendarFor(yyyymmdd);
        final int MONDAY_CODE = 2;
        final int FRIDAY_CODE = 6;
        final int dayOfWeekCode = calendar.get(Calendar.DAY_OF_WEEK);
        if(MONDAY_CODE <= dayOfWeekCode && dayOfWeekCode <= FRIDAY_CODE ) {
            return true;
        } else {
            return false;
        }
    }

    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {
        final Date date = WeekDays.validateAndParseDate(yyyymmdd);
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

