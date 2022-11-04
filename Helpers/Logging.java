package Helpers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Logging {
    public static void logWithTimeStamp(String msg) {
        System.out.println("[" + currentTimeStr() + "] " + msg);
    }
    
    public static String currentTimeStr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
