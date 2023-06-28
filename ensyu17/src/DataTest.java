import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void countWeekDays() throws ParseException {
        assertEquals(23, Data.countWeekDays("2023/05/01","2023/05/31"));
        assertEquals(6, Data.countWeekDays("2023/05/08","2023/05/15"));
        assertEquals(2, Data.countWeekDays("2023/05/13","2023/05/16"));
        assertEquals(13, Data.countWeekDays("2023/05/04","2023/05/22"));
        assertEquals(3, Data.countWeekDays("2023/05/26","2023/05/30"));
        assertThrows(ParseException.class, () -> Data.countWeekDays("2023-03-01","2023-05-31"));
        assertThrows(ParseException.class, () -> Data.countWeekDays("アイウエオ","アイウエオ"));
        assertThrows(ParseException.class, () -> Data.countWeekDays("2023-03-1","2023-03-7"));
        assertThrows(ParseException.class, () -> Data.countWeekDays("2023-3-01","20230-3-09"));
    }
}