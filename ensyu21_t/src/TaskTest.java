import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void isExpired()  throws URISyntaxException, IOException, ParseException, InterruptedException {
        Calendar c1 = Calendar.getInstance();
        Task task1 = new Task("タスク1", DateUtil.toYYYYMMDD(c1));
        assertFalse(task1.isExpired());
        Task task2 = new Task("タスク2", "2023/05/26");
        assertTrue(task2.isExpired());
        Task task3 = new Task("タスク3", "2023/12/26");
        assertFalse(task3.isExpired());
    }

}