import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;


public class Task {
    String name;
    String deadLineDate;
    int actualMinuteTime;


    public Task(String name, String deadLineDate) {
        this.name = name;
        this.deadLineDate = deadLineDate;
        this.actualMinuteTime = 0;
    }

    public boolean isExpired() throws URISyntaxException, IOException, InterruptedException, ParseException{        //比較の結果の返却
        if(this.countToDeadLineDate() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public int countToDeadLineDate() throws URISyntaxException, IOException, InterruptedException, ParseException {
        Calendar todayC = Calendar.getInstance();
        if(todayC.getTime().after(DateUtil.validateAndParseDate(this.deadLineDate))) {                          //afterは"."(todayC)の前で指定された時間が
            return -1 * DateUtil.countWorkingDays(this.deadLineDate, DateUtil.toYYYYMMDD(todayC));              //"()"(deadLineDate)の中の時間より前か後かを返す。
        } else {                                                                                                //(todayC)が後の場合はtrue
            return DateUtil.countWorkingDays(DateUtil.toYYYYMMDD(todayC), this.deadLineDate);                   //そうでない場合はfalseになる。
        }
    }

}