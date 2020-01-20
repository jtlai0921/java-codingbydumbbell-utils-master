package md5

import java.math.BigInteger
import java.security.MessageDigest

fun main() {
    val str = "pokkkk"

    // by Method
    println(toMD5(str))

    // by Extensions
    println(str.md5())
}

fun toMD5(str: String): String {

    // 取得 MD5 物件
    val md5 = MessageDigest.getInstance("MD5")

    // 透過 MD5 取得 byte[]
    val bytes = md5.digest(str.toByteArray())

    // 將陣列轉為 BigInteger，1 代表正數
    val bigInteger = BigInteger(1, bytes)

    // 透過 BigInteger 產出 16 進位的字串，再透過 padStart 將不足補 0
    return bigInteger.toString(16).padStart(32, '0')
}

//fun toMD5(str: String): String {
//    return BigInteger(1, MessageDigest.getInstance("MD5")
//        .digest(str.toByteArray())).toString(16).padStart(32, '0')
//}