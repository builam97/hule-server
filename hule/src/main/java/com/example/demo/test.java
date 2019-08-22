package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main( String[] args ){
       String a = "2019-08-15 10:39:01.000";
       String sendingTime = null;
       Date date;
       try {
           String b = "2019-08-15T03:39:01Z";
           System.out.println(Instant.parse(b));
           SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
                   "yyyy-MM-dd hh:mm:ss.SSS");
           date = datetimeFormatter1.parse(a);
//           Instant timestamp = date.getSeconds();
           System.out.println(date.toInstant());
       } catch (ParseException e) {
           e.printStackTrace();
       }
//        System.out.println(sendingTime);
    }
    
    @FunctionalInterface
    public interface NumToTextConverter {
        String convert(int x);
    }
    
    static void closureType() {
        NumToTextConverter numToTextConverter = num -> {
            System.out.println("abc" + num);
            String [] weeks = {"Mon", "Tue", "Web", "Thur", "Fri", "Sat", "Sun"};
            return (num > 0 && num <= weeks.length) ? weeks[num-1] : null;
        };
        System.out.println(numToTextConverter.convert(5));
    }
}
