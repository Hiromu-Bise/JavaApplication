import org.junit.jupiter.api.Test;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class WeekDaysTest {

    @Test
    void isWeekDay()  throws Exception{
        assertEquals(true, WeekDays.isWeekDay("2023/05/17"));
        assertEquals(true, WeekDays.isWeekDay("2023/05/15"));
        assertEquals(true, WeekDays.isWeekDay("2023/05/09"));
        assertEquals(true, WeekDays.isWeekDay("2023/05/30"));
        assertEquals(false, WeekDays.isWeekDay("2023/05/13"));
        assertEquals(false, WeekDays.isWeekDay("2023/05/20"));
        assertEquals(false, WeekDays.isWeekDay("2023/05/07"));
        assertEquals(false, WeekDays.isWeekDay("2023/05/28"));
        assertThrows(ParseException.class, () -> WeekDays.isWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> WeekDays.isWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> WeekDays.isWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> WeekDays.isWeekDay("2023-3-01"));
    }
}