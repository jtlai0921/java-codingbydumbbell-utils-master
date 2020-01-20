package regex.other;

import java.util.regex.Pattern;

public class Utils {

    // 判斷是否為「Email」格式
    public static boolean isEamilForm(String orginal) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
        return isMatch(regex, orginal);
    }

    // 判斷是否為「ip」格式
    public static boolean isIP(String orginal) {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
        return isMatch(regex, orginal);
    }

    // 判斷是否為「url」格式
    public static boolean isUrl(String orginal) {
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        return isMatch(regex, orginal);
    }

    // 驗證日期格式：yyyy-MM-dd HH:mm:ss
    public static boolean isDate_At(String orginal) {
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return isMatch(regex, orginal);
    }

    // 驗證日期格式：yyyy-MM-dd
    public static boolean isDate_On(String orginal) {
        String regex = "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
        return isMatch(regex, orginal);
    }

    private static boolean isMatch(String regex, String orginal) {
        if (orginal == null || orginal.trim().equals("")) return false;
        return Pattern.compile(regex).matcher(orginal).matches();
    }
}
