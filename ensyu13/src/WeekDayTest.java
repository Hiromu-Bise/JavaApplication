import org.junit.jupiter.api.Test;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayTest {

    @org.junit.jupiter.api.Test
    void isSaturdayOrSunday() throws ParseException {
        assertEquals(true, WeekDay.isSaturdayOrSunday("2023/05/06"));
        assertEquals(true, WeekDay.isSaturdayOrSunday("2023/05/07"));
        assertEquals(true, WeekDay.isSaturdayOrSunday("2023/05/28"));
        assertEquals(false, WeekDay.isSaturdayOrSunday("2023/05/04"));
        assertEquals(false, WeekDay.isSaturdayOrSunday("2023/05/10"));
        assertEquals(false, WeekDay.isSaturdayOrSunday("2023/05/30"));
        assertThrows(ParseException.class, () -> WeekDay.isSaturdayOrSunday("2023-03-01"));
        assertThrows(ParseException.class, () -> WeekDay.isSaturdayOrSunday("アイウエオ"));
        assertThrows(ParseException.class, () -> WeekDay.isSaturdayOrSunday("2023-03-1"));
        assertThrows(ParseException.class, () -> WeekDay.isSaturdayOrSunday("2023-3-01"));
    }
}