import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DateNextTest {

    @org.junit.jupiter.api.Test
    void isWeekDay() throws ParseException {
        assertEquals(false, DateNext.isWeekDay("2023/05/14"));
        assertEquals(true, DateNext.isWeekDay("2023/05/15"));
        assertEquals(true, DateNext.isWeekDay("2023/05/16"));
        assertEquals(true, DateNext.isWeekDay("2023/05/17"));
        assertEquals(true, DateNext.isWeekDay("2023/05/18"));
        assertEquals(true, DateNext.isWeekDay("2023/05/19"));
        assertEquals(false, DateNext.isWeekDay("2023/05/20"));
        assertEquals(false, DateNext.isWeekDay("2023/05/21"));
        assertEquals(true, DateNext.isWeekDay("2023/05/22"));
        assertEquals(true, DateNext.isWeekDay("2023/05/23"));
        assertEquals(false, DateNext.isWeekDay("2023/05/27"));
        assertEquals(false, DateNext.isWeekDay("2023/05/28"));
        assertThrows(ParseException.class, () -> DateNext.isWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> DateNext.isWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> DateNext.isWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> DateNext.isWeekDay("2023-3-01"));

    }

    @org.junit.jupiter.api.Test
    void isSaturdayOrSunday() throws ParseException {
        assertEquals(true, DateNext.isSaturdayOrSunday("2023/05/14"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/15"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/16"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/17"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/18"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/19"));
        assertEquals(true, DateNext.isSaturdayOrSunday("2023/05/20"));
        assertEquals(true, DateNext.isSaturdayOrSunday("2023/05/21"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/22"));
        assertEquals(false, DateNext.isSaturdayOrSunday("2023/05/23"));
        assertEquals(true, DateNext.isSaturdayOrSunday("2023/05/27"));
        assertEquals(true, DateNext.isSaturdayOrSunday("2023/05/28"));

    }

    @org.junit.jupiter.api.Test
    void getNextWeekDay() throws ParseException {
        assertEquals("2023/05/31", DateNext.getNextWeekDay("2023/05/30"));
        assertEquals("2023/06/01", DateNext.getNextWeekDay("2023/05/31"));
        assertEquals("2023/06/05", DateNext.getNextWeekDay("2023/06/02"));
        assertEquals("2023/05/02", DateNext.getNextWeekDay("2023/05/01"));
        assertEquals("2023/05/03", DateNext.getNextWeekDay("2023/05/02"));
        assertEquals("2023/05/22", DateNext.getNextWeekDay("2023/05/19"));
        assertEquals("2023/05/26", DateNext.getNextWeekDay("2023/05/25"));
        assertThrows(ParseException.class, () -> DateNext.getNextWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> DateNext.getNextWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> DateNext.getNextWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> DateNext.getNextWeekDay("2023-3-01"));
    }

    @org.junit.jupiter.api.Test
    void validateAndParseDate() throws ParseException {
        String inputDate = "2023-05-07";
        assertThrows(ParseException.class, () -> DateNext.validateAndParseDate(inputDate));
        String inputDate2 = "2023/05/07";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 5 - 1, 7, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), DateNext.validateAndParseDate(inputDate2));

    }

    @org.junit.jupiter.api.Test
    void countDaysBetween() {
    }
}