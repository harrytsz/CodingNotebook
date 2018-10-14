package The1Chapter;
/**
 * 欧几里得算法：
 * 计算两个非负整数 a 和 b 的最大公约数：
 * 若 a 是 0， 则最大公约数为 a。
 * 否则，将 a 除以 b 得到余数 r ， a 和 b 的最大公约数即为 b 和 r 的最大公约数。
 */

public class MaximumCommonDivisor {
    public static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        int r = a % b;
        return gcd(b, r);
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 6;
        int result = gcd(a, b);
        System.out.println("Result: " + result);
    }

}
