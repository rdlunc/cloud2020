import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author lunrongda
 * @create 2021-02-20 17:15
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();//默认时区
        System.out.println(zbj);

        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));//用指定时区获取当前时间
        System.out.println(zny);
    }
}
