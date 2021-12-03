import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ch05Ex09Util {
    public static void main(String [] args){
        Date tydate = new Date();
        SimpleDateFormat datefmt = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초\nEEEE\n");
        System.out.println("오늘 날짜와 시간\n\n-- Date클래스 --");
        System.out.println(datefmt.format(tydate));
        Calendar rtNow = Calendar.getInstance();
        int year = rtNow.get(Calendar.YEAR);
        int month = rtNow.get(Calendar.MONTH);
        int date = rtNow.get(Calendar.DATE);
        int hour = rtNow.get(Calendar.HOUR);
        int minute = rtNow.get(Calendar.MINUTE);
        System.out.printf("-- Calendar클래스 --\n%d년%d월%d일 %d시 %d분", year, month+1, date, hour, minute);
    }
}
