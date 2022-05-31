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

}