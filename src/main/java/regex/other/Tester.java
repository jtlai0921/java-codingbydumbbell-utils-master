package regex.other;

public class Tester {

    public static void main(String[] args) {

        // 判斷是否為「Email」格式
        String eamil = "codingbydumbbell@gmail.com";
        System.out.println(Utils.isEamilForm(eamil));

        // 判斷是否為「ip」格式
        String ip = "192.168.0.1";
        System.out.println(Utils.isIP(ip));

        // 判斷是否為「url」格式
        String url = "https://www.google.com.tw/";
        System.out.println(Utils.isUrl(url));

        // 驗證日期格式：yyyy-MM-dd HH:mm:ss
        String date_At = "2019-02-29 23:12:59";
        System.out.println(Utils.isDate_At(date_At));

        // 驗證日期格式：yyyy-MM-dd
        String date_On = "2020-02-29";
        System.out.println(Utils.isDate_On(date_On));
    }
}
