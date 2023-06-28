import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @org.junit.jupiter.api.Test
    void isExpired() {
    }

    @org.junit.jupiter.api.Test
    void countToDeadLineDate() {
    }

    @org.junit.jupiter.api.Test
    void sum() throws ParseException {
        int[] array1 = {1,2,3,4};
        assertEquals(10, Task.sum(array1));
        int[] array2 = {10,50,70};
        assertEquals(130, Task.sum(array2));
        int[] array3 = {17,48};
        assertEquals(65, Task.sum(array3));
        int[] array4 = {4,22,100,57,17};
        assertEquals(200, Task.sum(array4));
    }
}