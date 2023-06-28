import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;


public class Task {
    String name;
    String deadLineDate;
    int actualMinuteTime;


    public Task(String name, String deadLineDate, int actualMinuteTime) {
        this.name = name;
        this.deadLineDate = deadLineDate;
        this.actualMinuteTime = actualMinuteTime;
    }

    public boolean isExpired() throws URISyntaxException, IOException, InterruptedException, ParseException {
        if (this.countToDeadLineDate() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public int countToDeadLineDate() throws URISyntaxException, IOException, InterruptedException, ParseException {
        Calendar todayC = Calendar.getInstance();
        if (todayC.getTime().after(DateUtil.validateAndParseDate(this.deadLineDate))) {
            return -1 * DateUtil.countWorkingDays(this.deadLineDate, DateUtil.toYYYYMMDD(todayC));
        } else {
            return DateUtil.countWorkingDays(DateUtil.toYYYYMMDD(todayC), this.deadLineDate);
        }
    }

//    public int countRemainingDays() throws URISyntaxException, IOException, InterruptedException, ParseException {
//        return this.countToDeadLineDate();
//    }

    public static int sum(int[] array) throws ParseException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int sumActualTime(Task[] task) throws ParseException {
        int sum = 0;
        for (int i = 0; i < task.length; i++) {
            sum += task[i].actualMinuteTime;
        }
        return sum;
    }
}