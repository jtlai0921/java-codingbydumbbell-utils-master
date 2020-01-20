package regex.number;

import java.util.regex.Pattern;

public class Utils {

    // 判斷是否為正整數：可以含「+」號，第一個數字不能為 0
    public static boolean isPositiveInteger(String orginal) {
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal);
    }

    // 判斷是否為負整數：必需含「-」，第一個數字不能為 0
    public static boolean isNegativeInteger(String orginal) {
        return isMatch("^-[1-9]\\d*", orginal);
    }

    // 判斷是否為整數：由「+」、「-」、「0」及「正整數」、「負整數」所組成
    public static boolean isWholeNumber(String orginal) {
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);
    }

    // 判斷是否為正小數：可以含「+」號，必需含有「.」，排除「0.0」
    public static boolean isPositiveDecimal(String orginal) {
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);
    }

    // 判斷是否為負小數：必需含「-」、必需含有「.」，排除「0.0」
    public static boolean isNegativeDecimal(String orginal) {
        return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);
    }

    // 判斷是否為小數：正負小數及「0.0」
    public static boolean isDecimal(String orginal) {
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
    }

    // 判斷是否為數值
    public static boolean isRealNumber(String orginal) {
        return isWholeNumber(orginal) || isDecimal(orginal);
    }

    private static boolean isMatch(String regex, String orginal) {
        if (orginal == null || orginal.trim().equals("")) return false;
        return Pattern.compile(regex).matcher(orginal).matches();
    }
}
