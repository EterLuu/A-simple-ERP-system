package pdc.assignment.erp.util;

import java.util.regex.Pattern;

public class Judgement {

    private Judgement(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean judgeName(String username){
        String pattern = "[A-Za-z0-9 _-]{1,18}";

        return Pattern.matches(pattern, username);
    }

    public static boolean judgePassword(String password){
        String pattern = "[A-Za-z0-9_-]{1,18}";

        return Pattern.matches(pattern, password);
    }

    public static boolean judgeNumber(String number){
        String pattern = "^\\d{1,10}$|(?=^.{1,11}$)^\\d+\\.\\d{1,2}$";

        return Pattern.matches(pattern, number);
    }

    public static boolean judgeString(String number){
        String pattern = "[A-Za-z0-9+ _-]{0,24}";

        return Pattern.matches(pattern, number);
    }

    public static boolean judgeStringWithoutEmpty(String number){
        String pattern = "[A-Za-z0-9+ _-]{1,24}";

        return Pattern.matches(pattern, number);
    }
    public static boolean judgeLongString(String number){
        String pattern = "[A-Za-z0-9+ _-]{0,255}";

        return Pattern.matches(pattern, number);
    }

    public static boolean judgeLongStringWithoutEmpty(String number){
        String pattern = "[A-Za-z0-9 _-]{0,255}";

        return Pattern.matches(pattern, number);
    }
}
