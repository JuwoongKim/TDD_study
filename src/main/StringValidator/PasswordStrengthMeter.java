package main.StringValidator;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){

        boolean containNums;

        if(s.length()<8)
            return PasswordStrength.NORMAL;
        else {
            containNums = meetCountingNumberCriteria(s);
            if(containNums)
                return PasswordStrength.STRONG;
            else
                return PasswordStrength.NORMAL;
        }
    }

    private boolean meetCountingNumberCriteria(String s){

        for(char c : s.toCharArray()){
            if( Character.isDigit(c)) return true;
        }
        return false;
    }
}
