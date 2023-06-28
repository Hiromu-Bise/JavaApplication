import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class HogeHoge {
    public static boolean isWeekDay(String yyyymmdd) throws ParseException {            //平日判定
        final Calendar calendar = getCalendarFor(yyyymmdd);
        final int TUESDAY_CODE = 2;
        final int FRIDAY_CODE = 6;
        final int dayOfWeekCode = calendar.get(Calendar.DAY_OF_WEEK);
        if(TUESDAY_CODE <= dayOfWeekCode && dayOfWeekCode <= FRIDAY_CODE ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSaturdayOrSunday(String yyyymmdd) throws ParseException {       //休日判定
        return !isWeekDay(yyyymmdd);                                                        //"!"でisWeekdayの否定となるので
    }                                                                                       //逆の土日の判定になる

    public static String[] getNationalHoliday(int yyyy) throws URISyntaxException, IOException, InterruptedException  {
        final String responseBody = getResponseBodyTo("https://holidays-jp.github.io/api/v1/" + yyyy + "/date.json");
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(responseBody);
        return getKeyStringArr(jsonNode);
    }

    private static String[] getKeyStringArr(JsonNode jsonNode) {
        final int size = jsonNode.size();
        final String[] arr = new String[size];
        final Iterator<String> iterator = jsonNode.fieldNames();
        for (int i = 0; iterator.hasNext(); i++) {
            arr[i] = iterator.next().replace("-", "/");
        }
        return arr;
    }

    public static String getResponseBodyTo(String url) throws URISyntaxException, IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static boolean isNationalHoliday(String yyyymmdd) throws URISyntaxException, IOException, InterruptedException {
        final int year = getYearOf(yyyymmdd);
        final String[] nationalHolidays = getNationalHoliday(year);
        final ArrayList<String> arrDates = new ArrayList<>(Arrays.asList(nationalHolidays));
        return arrDates.contains(yyyymmdd);
    }

    private static int getYearOf(String yyyymmdd) {
        return Integer.parseInt(yyyymmdd.substring(0, 4));
    }

    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {
        final Date date = HogeHoge.validateAndParseDate(yyyymmdd);                      //フォーマットの変換
        final Calendar calendar = Calendar.getInstance();                               //現在の日付、時間を取得(calendarの定義)
        calendar.setTime(date);                                                         //日付、時間に"date"のものを設定する
        return calendar;
    }

    public static boolean isHoliday(String yyyymmdd) throws URISyntaxException, IOException, InterruptedException, ParseException {     //祝休日判定
        return isNationalHoliday(yyyymmdd) || isSaturdayOrSunday(yyyymmdd);                               //祝日または休日
    }


    public static Date validateAndParseDate(String inputDate) throws ParseException {       //"yyyymmdd"でかかれたものを
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");             //"yyyy/mm/dd"の形に直している
        sdf.setLenient(false);                                                              //日付が正しいかの判定
        return sdf.parse(inputDate);                                                        //string型をdate型に変換
    }

    public static Date addDaysToDate(Date date, int days) {
        final Calendar calendar = Calendar.getInstance();                                   //現在の日付、時間の取得
        calendar.setTime(date);                                                             //Date型から、calendar型への変換
        calendar.add(Calendar.DAY_OF_MONTH, days);                                          //指定した値の加算、減算
        return calendar.getTime();                                                          //calendar型から、date型への変換
    }

    public static int countWorkingDays(String from, String to) throws URISyntaxException, IOException, InterruptedException, ParseException {
        String[] daysStrings = getDaysStrBetween(from, to);
        int count = 0;
        for (int i = 0; i < daysStrings.length; i++) {
            if(!isHoliday(daysStrings[i]))
                count++;
        }
        return count;
    }

    public static String[] getDaysStrBetween(String from, String to) throws ParseException{
        Calendar fromC = getCalendarFor(from);                                                  //フォーマット変換
        Calendar toC = getCalendarFor(to);                                                      //    "
        int howManyDays = HogeHoge.countDaysBetween(fromC.getTime(), toC.getTime()) + 1;
        String[] strings = new String[howManyDays];
        int n = 0;
        while (n != howManyDays) {
            Calendar tmp = (Calendar) fromC.clone();
            tmp.add(Calendar.DAY_OF_MONTH, n);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String formattedDate = sdf.format(tmp.getTime());
            strings[n] = formattedDate;
            n++;
        }
        return strings;
    }

    public static int countDaysBetween(Date date1, Date date2) {            //時間を日付になおしている
        long difference = date2.getTime() - date1.getTime();
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }
}
