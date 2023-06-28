import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class HogeHogeTest {

    @Test
    void isWeekDay() throws Exception{
        assertEquals(false, HogeHoge.isWeekDay("2023/05/14"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/15"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/16"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/17"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/18"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/19"));
        assertEquals(false, HogeHoge.isWeekDay("2023/05/20"));
        assertEquals(false, HogeHoge.isWeekDay("2023/05/21"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/22"));
        assertEquals(true, HogeHoge.isWeekDay("2023/05/23"));
        assertEquals(false, HogeHoge.isWeekDay("2023/05/27"));
        assertEquals(false, HogeHoge.isWeekDay("2023/05/28"));
        assertThrows(ParseException.class, () -> HogeHoge.isWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> HogeHoge.isWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> HogeHoge.isWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> HogeHoge.isWeekDay("2023-3-01"));
    }

    @Test
    void isSaturdayOrSunday() throws Exception{
        assertEquals(true, HogeHoge.isSaturdayOrSunday("2023/05/14"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/15"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/16"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/17"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/18"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/19"));
        assertEquals(true, HogeHoge.isSaturdayOrSunday("2023/05/20"));
        assertEquals(true, HogeHoge.isSaturdayOrSunday("2023/05/21"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/22"));
        assertEquals(false, HogeHoge.isSaturdayOrSunday("2023/05/23"));
        assertEquals(true, HogeHoge.isSaturdayOrSunday("2023/05/27"));
        assertEquals(true, HogeHoge.isSaturdayOrSunday("2023/05/28"));
    }

    @Test
    void getNationalHoliday() throws Exception {
        String[] expected = {
                "2023/01/01",
                "2023/01/02",
                "2023/01/09",
                "2023/02/11",
                "2023/02/23",
                "2023/03/21",
                "2023/04/29",
                "2023/05/03",
                "2023/05/04",
                "2023/05/05",
                "2023/07/17",
                "2023/08/11",
                "2023/09/18",
                "2023/09/23",
                "2023/10/09",
                "2023/11/03",
                "2023/11/23"
        };
        System.out.println("actual");
        String[] actual = HogeHoge.getNationalHoliday(2023);
        System.out.println(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getResponseBodyTo() {
    }

    @Test
    void isNationalHoliday() throws Exception {
        assertEquals(true, HogeHoge.isNationalHoliday("2023/01/01"));
        assertEquals(true, HogeHoge.isNationalHoliday("2023/01/02"));
        assertEquals(false, HogeHoge.isNationalHoliday("2023/01/03"));
        assertEquals(false, HogeHoge.isNationalHoliday("2023/01/04"));
        assertEquals(false, HogeHoge.isNationalHoliday("2023/01/05"));
        assertEquals(false, HogeHoge.isNationalHoliday("2023/01/06"));
        assertEquals(false, HogeHoge.isNationalHoliday("2023/01/07"));
    }

    @Test
    void isHoliday() throws Exception {
        assertEquals(true, HogeHoge.isHoliday("2023/01/01"));
        assertEquals(true, HogeHoge.isHoliday("2023/01/02"));
        assertEquals(false, HogeHoge.isHoliday("2023/01/03"));
        assertEquals(false, HogeHoge.isHoliday("2023/01/04"));
        assertEquals(false, HogeHoge.isHoliday("2023/01/05"));
        assertEquals(false, HogeHoge.isHoliday("2023/01/06"));
        assertEquals(true, HogeHoge.isHoliday("2023/01/07"));
        assertEquals(true, HogeHoge.isHoliday("2023/01/08"));
        assertEquals(true, HogeHoge.isHoliday("2023/01/09"));
        assertEquals(true, HogeHoge.isHoliday("2022/01/08"));
        assertEquals(true, HogeHoge.isHoliday("2022/01/09"));
        assertEquals(true, HogeHoge.isHoliday("2022/01/10"));
        assertEquals(false, HogeHoge.isHoliday("2022/01/11"));
    }

    @Test
    void validateAndParseDate() throws ParseException {
        String inputDate = "2023-05-07";
        assertThrows(ParseException.class, () -> HogeHoge.validateAndParseDate(inputDate));
        String inputDate2 = "2023/05/07";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 5 - 1, 7, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), HogeHoge.validateAndParseDate(inputDate2));
    }

    @Test
    void addDaysToDate() {
    }

    @Test
    void countWorkingDays() throws URISyntaxException, IOException, InterruptedException, ParseException {
        assertEquals(2, HogeHoge.countWorkingDays("2023/05/11", "2023/05/12"));
        assertEquals(4, HogeHoge.countWorkingDays("2023/05/11", "2023/05/16"));
        assertEquals(7, HogeHoge.countWorkingDays("2023/05/11", "2023/05/20"));
        assertEquals(7, HogeHoge.countWorkingDays("2023/05/11", "2023/05/21"));
        assertEquals(0, HogeHoge.countWorkingDays("2023/05/20", "2023/05/21"));
        assertEquals(0, HogeHoge.countWorkingDays("2023/05/21", "2023/05/21"));
        assertEquals(1, HogeHoge.countWorkingDays("2023/01/01", "2023/01/03"));
        assertEquals(1, HogeHoge.countWorkingDays("2023/01/06", "2023/01/09"));
        assertEquals(2, HogeHoge.countWorkingDays("2023/01/06", "2023/01/10"));
        assertEquals(20, HogeHoge.countWorkingDays("2023/01/01", "2023/01/31"));
        assertEquals(6, HogeHoge.countWorkingDays("2022/12/27", "2023/01/04"));
    }

    @Test
    void getDaysStrBetween() throws ParseException {
        String[] actual1 = HogeHoge.getDaysStrBetween("2023/05/11", "2023/05/21");
        String[] expected1 = {
                "2023/05/11",
                "2023/05/12",
                "2023/05/13",
                "2023/05/14",
                "2023/05/15",
                "2023/05/16",
                "2023/05/17",
                "2023/05/18",
                "2023/05/19",
                "2023/05/20",
                "2023/05/21"
        };
        assertArrayEquals(expected1, actual1);

        String[] actual2 = HogeHoge.getDaysStrBetween("2022/12/27", "2023/01/04");
        String[] expected2 = {
                "2022/12/27",
                "2022/12/28",
                "2022/12/29",
                "2022/12/30",
                "2022/12/31",
                "2023/01/01",
                "2023/01/02",
                "2023/01/03",
                "2023/01/04"
        };
        assertArrayEquals(expected2, actual2);
    }

    @Test
    void countDaysBetween() {
    }
}