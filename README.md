# Core Java Volume 1-Fundamentals
记录学习Java核心技术卷Ⅰ(第十版)的笔记



## 第3章 Java的基本程序设计结构

### 3.1 注释

最常用的方式是使用`//`，其注释内容从`//`开始到本行结尾。也可以使用`/*`和`*/`将一段比较长的注释括起来。另外有

一种以`/**`开始，以`*/`结束。这种注释一般用于方法或者类。



### 3.2 数据类型

Java是一种强类型语言。

在Java中，一共有八种基本类型。其中有4种整型、2种浮点类型、1种用于表示Unicode编码的字符单元的字符类型char和1种用于表示真值的boolean类型。

**注释：**Java中有一个能够表示任意精度的算术包，通常称为”大数值“(big number)。虽然被称为大数值，**但它并不是一种新的Java类型，而是一个Java对象**。



#### 3.2.1 整型

整型用于表示没有小数部分的数值，**它允许是负数**。

| 类型  | 存储需求 | 取值范围                                 |
| ----- | -------- | ---------------------------------------- |
| int   | 4字节    | -2147483648~2147483647(正好超过20亿)     |
| short | 2字节    | -32768~32767                             |
| long  | 8字节    | -9223372036854775808~9223372036854775807 |
| byte  | 1字节    | -128~127                                 |



#### 3.2.2 浮点类型

| 类型   | 存储需求 | 取值范围                                      |
| ------ | -------- | --------------------------------------------- |
| float  | 4字节    | 大约±3.40282347E+38F(有效位数为6~7位)         |
| double | 8字节    | 大约±1.79769313486231570E+308(有效位数为15位) |

double表示这种类型的数值精度是float类型的两倍，称之为双精度数值。

**float类型的数值有一个后缀F或f。没有后缀F的浮点数值默认为double类型。**

**注释：**下面是用于表示溢出和出错情况的三个特殊的浮点数值：

- 正无穷大
- 负无穷大
- NaN(不是一个数字)

例如：一个正整数除以0的结果为正无穷大。计算0/0或者负数的平方根结果为NaN。

```java
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
/**输出：
c = NaN
c is NaN
d is POSITIVE_INFINITY
e is NEGATIVE_INFINITY
d is infinite
e is infinite
*/
```



#### 3.2.3 char类型

char类型原本用于表示单个字符。有些Unicode字符可以用一个char值描述，另外一些Unicode字符则需要两个char值。

char类型的字面量值要用单引号括起来。例如：’A‘是编码值为65所对应的字符常量。

`\u`是转义字符，表示后面是一个unicode字符

**强烈不建议在程序中使用char类型**

```java
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
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        //编码值
        System.out.println("A的编码值是：" + (int) A);
        char f = 65535;
        System.out.println("f = " + f);
        char g = 65536;//报错:java: 不兼容的类型: 从int转换到char可能会有损失
        System.out.println("g = " + g);
    }
/**
a = a
b = b
c = a
d = b
e = c
A的编码值是：65
*/
```

**其它转义序列：**

| 转义序列 | 名称   | Unicode值 |
| -------- | ------ | --------- |
| `\b`     | 退格   | \u0008    |
| `\t`     | 制表   | \u0009    |
| `\n`     | 换行   | \u000a    |
| `\r`     | 回车   | \u000d    |
| `\"`     | 双引号 | \u0022    |
| `\'`     | 单引号 | \u0027    |
| `\\`     | 反斜杠 | \u005c    |



#### 3.2.4 boolean类型

boolean(布尔)类型有两个值：false和true，用来判断逻辑条件。整型值与布尔值之间不能进行互相转换。

**C++注释：**

在C++中，数值甚至指针可以代替boolean值。值0相当于布尔值false，非0值相当于布尔值ture。



### 3.3 变量

在Java中，每个变量都有一个类型。在声明变量时，变量的类型位于变量名之前。每个声明都必须以分号结束。

在变量名命名中，`+`和`©`这样的符号不能出现在变量名中，空格也不行。另外不能使用`Java`保留字作为变量名。

变量名的长度基本上没有限制。

**标识符：**在Java语言中，标识符常用来给类、对象、变量、方法、接口、自定义数据类型等命名的。

**标识符命名规则：**

- 标识符由任意顺序的大小写字母(a-z,A-Z),数字(0-9)下划线(_)和美元符号($)组成
- 标识符不能以数字开头
- 标识符是区别大小写
- 没有长度限制，不能把java关键字作为标识符
- 标识符不能包含空格

**标识符命名规范：**

- 包名：多个单词都是小写 xxxyyyzzz

- 类名、接口名：所有单词首字母大写，大驼峰 XxxYyyZzz

- 变量、方法：第一个单词小写，后面单词首字母大写，小驼峰 xxxYyyZzz

使用Character类的isJavaIdentifierStart与isJavaIdentifierPart检查标识符

```java
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
         * e = true
         */
    }
```



#### 3.3.1 变量初始化

声明一个变量之后，必须用赋值语句对变量进行显式初始化。想对一个已经声明的变量进行赋值，就需要将变量名放在等号左侧，相应的赋值在等号右侧。



#### 3.3.2 常量

在Java中，利用关键字final指示变常量。关键字final表示这个变量只能被赋值一次。一旦被赋值之后，就不能够再更改了。习惯上，常量名使用全大写。

在Java中，经常希望某个常量可以在一个类中的多个方法中使用，通常将这些常量称为类常量。可以使用关键字static final设置一个类常量。类常量的定义位于main方法的外部。



## 3.4 运算符



