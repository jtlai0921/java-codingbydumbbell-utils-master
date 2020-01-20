package regex.string;

public class Tester {

    public static void main(String[] args) {

        // 判斷是否為全形英文字元
        String fullWidthCharacter = "ＵＴＩＬＳ";
        System.out.println(Utils.isFullWidthCharacter(fullWidthCharacter));

        // 判斷是否為「中/英字元」、「,」、「-」或「空白字元」，用於判斷姓名
        String chineseOrEnglishCharacter = "王阿明 A-Ming, Wang";
        System.out.println(Utils.isChineseOrEnglishCharacter(chineseOrEnglishCharacter));

        // 判斷是否為「中文字元」
        String chineseCharacter = "王阿明";
        System.out.println(Utils.isChineseCharacter(chineseCharacter));

        // 判斷是否有「空格字元」
        String spaceString = "coding by dumbbell";
        System.out.println(Utils.hasSpace(spaceString));

        // 判斷是否為「英／數字字元」
        String englishNumString = "coding2019";
        System.out.println(Utils.isEnglishOrNum(englishNumString));
    }
}
