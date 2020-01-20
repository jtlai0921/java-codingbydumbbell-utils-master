package regex.number;

public class Tester {

    public static void main(String[] args) {

        // 判斷是否為正整數：可以含「+」號，第一個數字不能為 0
        String positiveInteger = "+2019";
        System.out.println(Utils.isPositiveInteger(positiveInteger));

        // 判斷是否為負整數：必需含「-」，第一個數字不能為 0
        String negativeInteger = "-2019";
        System.out.println(Utils.isNegativeInteger(negativeInteger));

        // 判斷是否為整數：由「+」、「-」、「0」及「正整數」、「負整數」所組成
        String wholeNumber = "2019";
        System.out.println(Utils.isWholeNumber(wholeNumber));

        // 判斷是否為正小數：可以含「+」號，必需含有「.」，排除「0.0」
        String positiveDecimal = "+0.4";
        System.out.println(Utils.isPositiveDecimal(positiveDecimal));

        // 判斷是否為負小數：必需含「-」、必需含有「.」，排除「0.0」
        String negativeDecimal = "-0.4";
        System.out.println(Utils.isNegativeDecimal(negativeDecimal));

        // 判斷是否為小數：正負小數及「0.0」
        String decimal = "-7.0";
        System.out.println(Utils.isDecimal(decimal));

        // 判斷是否為數值
        String number = "12.8";
        System.out.println(Utils.isRealNumber(number));
    }
}
