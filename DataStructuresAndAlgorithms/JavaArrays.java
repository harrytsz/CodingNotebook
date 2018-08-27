package JavaNoteBook;

import java.util.Arrays;

public class JavaArrays {
    public static void main(String[] args) {

          //-----------------------------//
         // 记录Java中Array的定义以及方法//
        // -----------------------------//

        int[] a;     // 仅仅是声明数组变量a，并未将a初始化为一个真正的数组

        int[] b = new int[100];   //声明并创建了可以存储100个整数的数组

        String[] names = new String[10];   // 创建一个包含10个字符串的数组，所有字符串都为 null
        //如果希望这个数组包含空串：
        for (int i=0; i<10; i++) names[i] = "";


        //------------ for each 循环

        //Java中功能强大的循环结构，可以用来依次处理数组中的每个元素（其他类型的元素集合亦可）而不必为指定下标分心：
        for (int element : b)
            System.out.println(element);

        //有个非常方便的方式可以打印数组中的所有值，即利用Arrays类的toString方法：
        System.out.println(Arrays.toString(b));


        //------------ 数组初始化以及匿名数组

        //创建数组对象并且同时赋予初始值：
        int[] smallPrimes = {2,3,5,7,11,13};
        //甚至还可以初始化一个匿名的数组(这种使用方法可以在不创建新变量的情况下重新初始化一个数组)：
        smallPrimes = new int[] {17,19,23,31,37};

        //--注释：
        // 在Java中，允许数组长度为0，在编写一个结果为数组的方法时，如果碰巧结果为空，则这种语法形式就显得非常有用。此时可以创建一个长度为0的数组：
        // new elementType[0]
        // 值得注意的是，数组长度为 0 和 null 不同！！！！

        //------------ 数组拷贝

        //在Java中，允许将一个数组变量拷贝给另一个数组变量，此时，两个变量将引用同一个数组：
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[5] = 12;  //Now,smallPrimes[5] is also 12

        //如果希望将一个数组的所有值拷贝到一个新的数组中去，就要使用Arrays类的copyOf方法：
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        //这个方法通常用来增加数组的大小：
        luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
        //如果数组元素是数值型，那么多余的元素将被赋值为0； 如果数组元素是布尔型，则将赋值为false。相反地，如果长度小于原始数组的长度，则只拷贝最前面的数据元素。


        //------------ 数组排序

        //要想对数值型数组进行排序，可以使用Arrays类中的方法sort方法：
        int[] c = new int[1000];
        Arrays.sort(c);
        for (int k : c)
            System.out.println(k);

        //或者将整个排序好的数组打印出来：
        System.out.println(Arrays.toString(c));

        //----------- java.util.Arrays 1.2
        static String toString(type[] d)    // 返回包含a中数据元素的字符串，这些数据被放在括号内，并用逗号分隔。

        static type copyOf(type[] d, int length)  //

        static type copyOfRange(type[] d, int start, int end)   //

        static void sort(type[] d)    //采用优化的快速排序算法对数组进行排序


        //采用二分搜索算法查找值v。如果查找成功，则返回相应的下标值；否则，返回一个负数值。
        static int binarySearch(type[] d, type v)
        static int binarySearch(type[] d, int start, int end, type v)

        static void fill(type[] d, type v)  //将数组的所有数据元素值设置为v

        static boolean equals(type[] e, type[] f)  //如果两个数组大小相同，并且下标相同的元素都对应相等，返回true

        //--------- 多维数组
        int[][] magicSquare =
                {
                        {16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 17, 12},
                        {4, 15, 14, 1}
                };

        //for each 循环语句不能自动处理二维数组的每一个元素，它是按照行，也就是一维数组处理的。要想访问二维数组的所有元素，需要使用两个嵌套的循环：
        for (int[] row : magicSquare)
            for (int value : row)
                System.out.println(value);

        //要想快速打印一个二维数组的数据元素列表，可以调用：
        System.out.println(Arrays.deepToString(magicSquare));

        //Java中多维数组变量由于可以单独地存取数组的某一行，所以可以让两行交换：
        final int NRATES = 6;
        final int NYEARS = 10;
        double[][] balances = new double[NRATES][NYEARS];

        double[] temp = balances[i];
        balances[i] = balances[i+1];
        balances[i+1] = temp;

        //-------不规则多维数组
        public class LotteryArrays
        {
            final int NMAX = 10;

            int[][] odds = new int[NMAX+1][];
            for(int n=0; n <=NMAX; n++)
                odds[n] = new int[n+1];

            for(int n=0; n < odds.length; n++)
                for (int k=0; k<odds[n].length; k++)
                {
                    int lotteryOdds = 1;
                    for (int i = 1; i <= k; i++)
                        lotteryOdds = lotteryOdds * (n-i+1)/i;
                    odds[n][k] = lotteryOdds;
                }

             for (int[] row : odds)
            {
                for (int odd : row)
                    System.out.println("%4d", odd);
                System.out.println();
            }
        }
    }
}
