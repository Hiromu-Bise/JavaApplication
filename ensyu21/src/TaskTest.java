import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void isExpired() throws ParseException {
        assertEquals(true, Task.isExpired("2023/06/08"));
        assertEquals(true, Task.isExpired("2023/05/01"));
        assertEquals(true, Task.isExpired("2023/06/09"));
        assertEquals(true, Task.isExpired("2022/08/09"));
        assertEquals(false, Task.isExpired("2023/06/10"));
        assertEquals(false, Task.isExpired("2023/06/30"));
        assertEquals(false, Task.isExpired("2023/07/09"));
        assertEquals(false, Task.isExpired("2024/05/09"));
    }
}