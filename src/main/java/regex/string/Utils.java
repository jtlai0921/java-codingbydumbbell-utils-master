package regex.string;

import java.util.regex.Pattern;

public class Utils {

    // 判斷是否為「英／數字字元」
    public static boolean isEnglishOrNum(String string) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
        return pattern.matcher(string).matches();
    }

    // 判斷是否有「空格字元」
    public static boolean hasSpace(String string) {
        Pattern pattern = Pattern.compile("[^\\s*\t\r\n]+$");
        return !pattern.matcher(string).matches();
    }

    // 判斷是否為「中文字元」
    public static boolean isChineseCharacter(String string) {
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]");
        for (char c : string.toCharArray())
            if (!pattern.matcher(String.valueOf(c)).matches()) return false;
        return true;
    }

    // 判斷是否為「中/英字元」、「,」、「-」或「空白字元」
    public static boolean isChineseOrEnglishCharacter(String string) {
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]");
        for (char c : string.toCharArray()) {
            if (!(pattern.matcher(String.valueOf(c)).matches() ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z') ||
                    c == ',' || c == ' ' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    // 判斷是否為「全形英文字元」
    public static boolean isFullWidthCharacter(String string) {
        Pattern pattern = Pattern.compile("[\\uFE30-\\uFFA0]");
        for (String s : string.split(""))
            if (!pattern.matcher(s).matches()) return false;
        return true;
    }
}
