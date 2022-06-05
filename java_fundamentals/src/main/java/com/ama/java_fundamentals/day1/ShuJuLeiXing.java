package com.ama.java_fundamentals.day1;

import org.junit.jupiter.api.Test;

/**
 * 第三章：数据类型
 *
 * @Version 0.0.1
 * @Author WenZhe Wang
 * @Date 2022/5/31 11:32
 */
public class ShuJuLeiXing {

    /**
     * 浮点类型
     */
    @Test
    public void test1() {
        double a = 0.0;
        double b = 0.0;
        double c = a / b;
        double d = 10.0 / 0;
        double e = -10.0 / 0;
        System.out.println("c = " + c);
        if (Double.isNaN(c)) {
            System.out.println("c is NaN");
        }
        if (Double.POSITIVE_INFINITY == d) {//正无穷
            System.out.println("d is POSITIVE_INFINITY");
        }
        if (Double.NEGATIVE_INFINITY == e) {//负无穷
            System.out.println("e is NEGATIVE_INFINITY");
        }
        if (Double.isInfinite(d)) {//判断是否是无穷
            System.out.println("d is infinite");
        }
        if (Double.isInfinite(e)) {//判断是否是无穷
            System.out.println("e is infinite");
        }
    }

    /**
     * char类型
     * char类型的范围是0~65535，超出这个范围就会报错
     */
    @Test
    public void test2() {
        char a = 'a';
        char b = 'b';
        char c = '\u0061';
        char d = '\u0062';
        char e = '\u0063';
        char A = 'A';
        char h = '\u0022';
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("h = " + h);
        //编码值
        System.out.println("A的编码值是：" + (int) A);
        char f = 65535;
        System.out.println("f = " + f);
//        char g = 65536;//报错:java: 不兼容的类型: 从int转换到char可能会有损失
//        System.out.println("g = " + g);
        /**
         * 输出：a = a
         *      b = b
         *      c = a
         *      d = b
         *      e = c
         *      h = "
         *      A的编码值是：65
         *      f = ￿
         */
    }

    /**
     * 判断是否是标识符
     * static boolean isJavaIdentifierPart(char ch)
     * 确定指定字符是否可以是 Java 标识符中首字符以外的部分。
     * static boolean isJavaIdentifierPart(int codePoint)
     * 确定字符（Unicode 代码点）是否可以是 Java 标识符中首字符以外的部分。
     * static boolean isJavaIdentifierStart(char ch)
     * 确定是否允许将指定字符作为 Java 标识符中的首字符。
     * static boolean isJavaIdentifierStart(int codePoint)
     * 确定是否允许将字符（Unicode 代码点）作为 Java 标识符中的首字符。
     */
    @Test
    public void test3() {
        boolean a = Character.isJavaIdentifierStart('a');
        boolean b = Character.isJavaIdentifierStart('1');
        boolean c = Character.isJavaIdentifierStart('_');
        boolean d = Character.isJavaIdentifierStart('$');
        boolean e = Character.isJavaIdentifierPart('$');
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        /**
         * a = true
         * b = false
         * c = true
         * d = true
         */
    }

    /**
     * 数学函数与常量
     */
    @Test
    public void test4() {
        double x = 4;
        double y = Math.sqrt(x);
        System.out.println("y = " + y);
        /**
         * 输出：y = 2.0
         */
    }

    /**
     * 幂运算
     */
    @Test
    public void test5() {
        double y = Math.pow(2.0, 3.0);
        System.out.println("y = " + y);
        /**
         * 输出：y = 8.0
         */
    }

    /**
     * 数值类型之间的转换
     */
    @Test
    public void test6() {
        int n = 123456789;
        float b = n;
        System.out.println("b = " + b);
        /**
         * 输出：b = 1.23456792E8
         */
    }

    /**
     * 强制类型转换
     * 结果：整数
     */
    @Test
    public void test7() {
        double x = 9.997;
        int nx = (int) x;
        System.out.println("nx = " + nx);
        /**
         * 输出：nx = 9
         */
    }

    /**
     * 强制类型转换；舍入运算
     */
    @Test
    public void test8() {
        double x = 9.997;
        int nx = (int) Math.round(x);
        System.out.println("nx = " + nx);
        /**
         * 输出：nx = 10
         */
    }

    /**
     * 强制类型转换；超出强制转换类型的范围
     */
    @Test
    public void test9() {
        int a = 300;
        byte b = (byte) a;
        System.out.println("b = " + b);
        /**
         * 输出：b = 44
         */
    }

    /**
     * 结合赋值和运算符
     */
    @Test
    public void test10() {
        int x = 2;
        x += 4;
        System.out.println("x = " + x);
        /**
         * 输出：x = 6
         */
    }

    /**
     * 自增和自减运算符
     */
    @Test
    public void test11() {
        int x = 2;
        x++;
        System.out.println("x = " + x);
        /**
         * 输出：x = 3
         */
        int y = 2;
        y--;
        System.out.println("y = " + y);
        /**
         * 输出：y = 1
         */
    }

    /**
     * n++与++n是有区别
     */
    @Test
    public void test12() {
        int x = 2;
        int y = x++;
        System.out.println("x = " + x + " y = " + y);
        /**
         * 输出：x = 3 y = 2
         */
        int z = 2;
        int w = ++z;
        System.out.println("z = " + z + " w = " + w);
        /**
         * 输出：z = 3 w = 3
         */
    }

    @Test
    public void test13() {
        int m = 7;
        int n = 7;
        int a = 2 * ++m;//a = 16,m = 8
        int b = 2 * n++;//b = 14,n = 8
        System.out.println("a = " + a + " b = " + b);
        /**
         * 输出：a = 16 b = 14
         */
    }

    /**
     * 关系和boolean运算符;
     * &&与，||或，!非
     */
    @Test
    public void test14() {
        int x = 2;
        int y = 3;
        boolean b1 = x > y;
        boolean b2 = x < y;
        boolean b3 = x >= y;
        boolean b4 = x <= y;
        boolean b5 = x == y;
        boolean b6 = x != y;
        System.out.println("b1 = " + b1 + " b2 = " + b2 + " b3 = " + b3 + " b4 = " + b4 + " b5 = " + b5 + " b6 = " + b6);
        /**
         * 输出：b1 = false b2 = true b3 = false b4 = true b5 = false b6 = true
         */
    }

    /**
     * 逻辑运算符;
     * &&与，||或的区别
     * &&与：只有两个表达式都为true时，才返回true
     * ||或：只要有一个表达式为true时，就返回true
     */
    @Test
    public void test15() {
        int x = 2;
        int y = 3;
        boolean b1 = x > y && x < y;
        boolean b2 = x > y || x < y;
        System.out.println("b1 = " + b1 + " b2 = " + b2);
        /**
         * 输出：b1 = false b2 = true
         */
    }

    /**
     * 三元运算符
     * 当表达式为true时，返回第一个表达式的值;
     * 当表达式为false时，返回第二个表达式的值
     */
    @Test
    public void test16() {
        int x = 2;
        int y = 3;
        int z = x > y ? x : y;
        int w = x > y ? y : x;
        System.out.println("z = " + z);
        System.out.println("w = " + w);
        /**
         * 输出：z = 3 w = 2
         */
    }

    /**
     * 与运算符
     */
    @Test
    public void test17() {
        int a = 129;
        int b = 128;
        System.out.println("a和b的“与”的结果是：" + (a & b));
        /*分析这个程序：
        “a”的值是129，转换成二进制就是10000001，
        而“b”的值是128，转换成二进制就是10000000。
        根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128。
        */
    }

    /**
     * 或运算符
     */
    @Test
    public void test18() {
        int a = 129;
        int b = 128;
        System.out.println("a和b的“或”的结果是：" + (a | b));
        /*分析这个程序段：
        a的值是129，转换成二进制就是10000001，
        而b的值是128，转换成二进制就是10000000，
        根据或运算符的运算规律，只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。
        */
    }

    /**
     * 异或运算符
     */
    @Test
    public void test19() {
        int a = 15;
        int b = 2;
        System.out.println("a与b的异或的结果是：" + (a ^ b));
        /**
         * 输出：a与b的异或的结果是：13
         * 分析：a的值是15，转换成二进制为1111，
         *      而b的值是2，转换成二进制为0010，
         *      根据异或的运算规律，可以得出其结果为1101
         *      即13
         */
    }

    /**
     * 非运算符
     */
    @Test
    public void test20() {
        int a = 2;
        System.out.println("a的“非”的结果是：" + (~a));
        /**
         * 输出：a的“非”的结果是：-3
         */
    }

    /**
     * 字符串：子串
     */
    @Test
    public void test21() {
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        System.out.println("s===" + s);
        /**
         * 输出：s===Hel
         */
    }

    /**
     * 字符串：拼接
     */
    @Test
    public void test22() {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        System.out.println("s3===" + s3);
        /**
         * 输出：s3===HelloWorld
         */
    }

    /**
     * 当将一个字符串与一个非字符串的值进行拼接时，后者被转换成字符串。
     */
    @Test
    public void test23() {
        String s1 = "Hello";
        int i = 100;
        String s2 = s1 + i;
        System.out.println("s2===" + s2);
        /**
         * 输出：s2===Hello1
         */
    }

    /**
     * 字符串：拼接
     */
    @Test
    public void test24() {
        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println("all===" + all);
        /**
         * 输出：all===S/M/L/XL
         */
    }

    /**
     * 字符串：比较区分大小写
     */
    @Test
    public void test25() {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "World";
        String s4 = "world";
        System.out.println("s1.equals(s2)===" + s1.equals(s2));
        System.out.println("s1.equals(s3)===" + s1.equals(s3));
        System.out.println("s3.equals(s4)===" + s3.equals(s4));
        /**
         * 输出：s1.equals(s2)===true
         *      s1.equals(s3)===false
         *      s3.equals(s4)===false
         */
    }

    /**
     * 字符串：比较不区分大小写
     */
    @Test
    public void test26() {
        String s1 = "Hello";
        String s2 = "hello";
        System.out.println("s1.equalsIgnoreCase(s2)===" + s1.equalsIgnoreCase(s2));
        /**
         * 输出：s1.equalsIgnoreCase(s2)===true
         */
    }

    /**
     * 字符串：判断是否为空
     */
    @Test
    public void test27() {
        String str = "";
        if (str.length() == 0) {
            System.out.println("length方法===str为空");
        }
        //或者
        if (str.equals("")) {
            System.out.println("equals---str为空");
        }
        //或者
        if (str.isEmpty()) {
            System.out.println("isEmpty===str为空");
        }
        /**
         * 输出：length方法===str为空
         *      equals---str为空
         *      isEmpty===str为空
         */
    }

    /**
     * 字符串：判断是否为NULL
     */
    @Test
    public void test28() {
        String str = null;
        if (str == null) {
            System.out.println("str为null");
        }
        /**
         * 输出：str为null
         */
    }

    /**
     * 字符串：既不是null也不为空串
     */
    @Test
    public void test29() {
        String str = "ama";
        if (str != null && str.length() != 0) {
            System.out.println("str不为null且不为空串");
        }
        /**
         * 输出：str不为null且不为空串
         */
    }

    /**
     * 码点与代码单元
     */
    @Test
    public void test30() {
        String greeting = "Hello";
        int n = greeting.length();
        System.out.println("n===" + n);
        /**
         * 输出：n===5
         */
    }

    /**
     * 码点数量
     */
    @Test
    public void test31() {
        String greeting = "Hello";
        int n = greeting.codePointCount(0, greeting.length());
        System.out.println("n===" + n);
        /**
         * 输出：n===5
         */
    }

    /**
     * charAt方法返回指定码点的字符
     */
    @Test
    public void test32() {
        String greeting = "Hello";
        char c = greeting.charAt(0);
        char c1 = greeting.charAt(4);
        System.out.println("c===" + c);
        System.out.println("c1===" + c1);
        /**
         * 输出：c===H
         *     c1===o
         */
    }

    /**
     * 第i个码点
     */
    @Test
    public void test33() {
        String greeting = "Hello";
        int index = greeting.offsetByCodePoints(0, 2);
        int cp = greeting.codePointAt(index);
        System.out.println("index===" + index);
        System.out.println("cp===" + cp);
        char l ='l';
        System.out.println("l===" + (int)l);
        /**
         * 输出：index===2
         *      cp===108
         *      l===108
         */
    }

}