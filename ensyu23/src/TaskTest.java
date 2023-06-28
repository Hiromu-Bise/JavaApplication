import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @org.junit.jupiter.api.Test
    void isExpired() throws URISyntaxException, IOException, ParseException, InterruptedException {
        Task task1 = new Task("タスク1", "2023/06/06");
        assertTrue(task1.isExpired());
        Task task2 = new Task("タスク2", "2023/05/26");
        assertTrue(task2.isExpired());
        Task task3 = new Task("タスク3", "2023/12/26");
        assertFalse(task3.isExpired());
        Task task4 = new Task("タスク4", "2023/06/07");
        assertFalse(task4.isExpired());
    }

    @org.junit.jupiter.api.Test
    void countToDeadLineDate() {
    }

//    @org.junit.jupiter.api.Test
//    void countRemainingDays() throws URISyntaxException, IOException, ParseException, InterruptedException {
//        Calendar c1 = Calendar.getInstance();
//        Task task1 = new Task("タスク1", DateUtil.toYYYYMMDD(c1));
//        assertEquals(0, task1.countRemainingDays());
//        Task task2 = new Task("タスク2", "2023/06/15");
//        assertEquals(3,task2.countToDeadLineDate());
//    }
}