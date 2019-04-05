package util;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GetCurrentTime {
    public static String currentTime(){
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy_mm_hh_mm_ss");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return sdf.format(ts);
    }
}
