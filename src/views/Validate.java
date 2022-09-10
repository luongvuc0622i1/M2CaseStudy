package views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Validate instance = null;
    private static final String ACCOUNT_REGEX = "[a-zA-Z0-9]{7,9}";
    private static final String PASS_REGEX = "([A-Z]{1})([a-z]{1,9})([0-9]{1,9})"; //Viết hoa chữ cái đầu và bắt buộc có số ở cuối
    private static final String PHONE_REGEX = "(\\+84)(-)([0-9]{9})";
    private static final String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9]{0,9}[._-]?[a-zA-Z0-9]{1,10}@[a-z]+\\.(com|vn)+$";

    private static final String ID_BOOK = "CGMD-Book-[0-9]{1,3}";
    private static final String ID_ADMIN = "CGMD-Admin-[0-9]{1,3}";
    private static final String ID_MEMBER = "CGMD-Member-[0-9]{1,3}";
    private static final String ID_ORDER = "CGMD-Order-[0-9]{1,3}";
    private static final String ID_DRAWSTUFF = "DS_[0-9]{1,3}";
    private static final String ID_BEAUTISTUFF = "BS_[0-9]{1,3}";

    private Validate() {
    }

    public static Validate getInstance() {
        if (instance == null) {
            return instance = new Validate();
        } else return instance;
    }

    public boolean validateAccount(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePassword(String regex) {
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePhone(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateBookID(String regex){
        Pattern pattern = Pattern.compile(ID_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateAdminID(String regex){
        Pattern pattern = Pattern.compile(ID_ADMIN);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateMemberID(String regex){
        Pattern pattern = Pattern.compile(ID_MEMBER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateOrderID(String regex){
        Pattern pattern = Pattern.compile(ID_ORDER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateDrawStuffID(String regex){
        Pattern pattern = Pattern.compile(ID_DRAWSTUFF);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean validateBeautiStuffID(String regex){
        Pattern pattern = Pattern.compile(ID_BEAUTISTUFF);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
