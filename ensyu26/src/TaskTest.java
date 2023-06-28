import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @org.junit.jupiter.api.Test
    void isExpired() throws URISyntaxException, IOException, InterruptedException, ParseException  {
    }

    @org.junit.jupiter.api.Test
    void countToDeadLineDate() throws URISyntaxException, IOException, InterruptedException, ParseException {
    }

    @org.junit.jupiter.api.Test
    void sum() throws ParseException {
    }

    @org.junit.jupiter.api.Test
    void sumActualTime() throws ParseException {
        Task task1 = new Task("task1", "2023/06/30", 100);
        Task task2 = new Task("task2", "2023/07/31", 200);
        Task task3 = new Task("task3", "2023/08/31", 300);
        Task[] task1_3 = {task1, task2, task3};
        assertEquals(600, Task.sumActualTime(task1_3));
        Task task4 = new Task("task4", "2023/06/30", 55);
        Task task5 = new Task("task5", "2023/07/31", 230);
        Task task6 = new Task("task6", "2023/08/31", 180);
        Task[] task4_6 = {task4, task5, task6};
        assertEquals(465, Task.sumActualTime(task4_6));

    }
}