package com.example.demo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String NAME_REGEX = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+";
    private static final String BIRTH_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    private static final String GENDER_REGEX = "Male|Female";
    private static final String CARD_REGEX = "[\\d]{3,}(-)[\\d]{2,}(-)[\\d]{4,}";
    private static final String PHONE_REGEX = "^[\\d\\s]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$";
    private static final String SPECIAL_SIGN_REGEX = "/^[a-zA-Z0-9 ]+$/";
    private static final String DATE_MONTH_YEAR_REGEX = "^\\\\d{4}\\\\-(0?[1-9]|1[012])\\\\-(0?[1-9]|[12][0-9]|3[01])$";
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String CODE_REGEX = "^(FE)[\\d]{4}$";
    private static final String UNIT_REGEX = "kg/ngay|kg/tuan|kg/thang";
    private static final String TRAILER_URL_REGEX = "^(https://www.youtube.com)[0-9a-zA-Z./?=&_-]+$";
    private static Pattern pattern;
    private static Matcher matcher;

    public boolean regexCode(String string){
        pattern = Pattern.compile(CODE_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public boolean regexUnit(String string){
        pattern = Pattern.compile(UNIT_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexEmail(String string){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexName(String string){
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexGender(String string){
        pattern = Pattern.compile(GENDER_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexCard(String string){
        pattern = Pattern.compile(CARD_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public boolean regexPhone(String string){
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
    public boolean regexPass(String string){
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexSpecialSign(String string){
        pattern = Pattern.compile(SPECIAL_SIGN_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexDateMonthYear(String string){
        pattern = Pattern.compile(DATE_MONTH_YEAR_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexNumber(String string){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean regexTrailerUrl(String string){
        pattern = Pattern.compile(TRAILER_URL_REGEX);
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
