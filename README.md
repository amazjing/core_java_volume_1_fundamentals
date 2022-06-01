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



### 3.4 运算符

在Java中，使用算术运算符`+`、`-`、`*`、`/`表示加、减、乘、除运算。

需要注意，整数被0除将会产生一个异常，而浮点数被0除将会得到无穷大或者NaN结果。



#### 3.4.1 数学函数与常量

在Math类中，包含了各种各样的数学函数。要想计算一个数值的平方根，可以使用**sqrt**方法。

```java
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
```

**注释：**Math类中的**sqrt**方法处理的不是对象，这样的方法被称为静态方法。

在Java中，没有幂运算，因此需要借助于Math类的**pow**方法。

```java
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
```

将y的值设置为2的3次幂。**pow**方法有两个double类型参数，其返回结果也为double类型。

Math类提供了一些常用的三角函数。

- Math.sin
- Math.cos
- Math.tan
- Math.atan
- Math.atan2



#### 3.4.2 数值类型之间的转换

经常需要将一种数值类型转换为另一种数值类型。数值之间的转换如图，在图中有6个实心箭头，表示无信息丢失的转换；有3个虚箭头，表示可能有精度损失的转换。

![20220601095046](http://typora-imagelist.oss-cn-qingdao.aliyuncs.com/20220601095046.png)

例如，123456789是一个大整数，它所包含的位数比float类型所能够表达的位数多。当将这个整数数值转为float类型时，将会得到同样大小结果，但却失去了一定的精度。

```java
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
```

当使用上面两个数值进行二元操作时，(例如n+f，n是整数，f是浮点数)，先要将两个操作数转换为同一种类型，然后再进行计算。

- 如果两个操作数中有一个是double类型，另外一个操作数就会转换为double类型。
- 否则，如果其中一个操作数是float类型，另一个操作数将会转换为float类型。
- 否则，如果其中一个操作数是long类型，另一个操作数将会转换为long类型。
- 否则，两个操作数都将转换为int类型。



#### 3.4.3 强制类型转换

在上节看到，在必要的时候，int类型的值将会自动转换为double类型。强制类型转换的语法格式是在圆括号中给出想要转换的目标类型，后面是待转换的变量名。例如：

```java
/**
     * 强制类型转换
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
```

如果想对浮点数进行舍入运算，以便得到最接近的整数，那就需要**Math.round**方法。

```java
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
```

当调用round的时候，仍然需要使用强制类型转换(int)。其原因是round方法返回结果为long类型。

**警告：**如果试图将一个数值从一种类型强制转换为另一种类型，而又超出了目标类型的表示范围。结果就会截断成一个完全不同的值。例如

```java
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
```



#### 3.4.4 结合赋值和运算符

```java
x += 4;
//等价于：
x = x + 4;
```

一般地，要把运算符放在=号左边，如*=或%=

```java
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
```

**注释：**如果运算符得到一个值，其类型与左侧操作数的类型不同，就会发生强制类型转换。



#### 3.4.5 自增与自减运算符

**n++**将变量n的当前值加1，n--则将n的值减1。

```java
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
```



