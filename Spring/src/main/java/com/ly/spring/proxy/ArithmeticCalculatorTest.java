package com.ly.spring.proxy;

import org.junit.jupiter.api.Test;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 16:09 2018/10/30
 * @Modified By:
 */
public class ArithmeticCalculatorTest {

    @Test
    public void test() {
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();

        int add = calculator.add(150, 150);
        System.out.println(add);

        int sub = calculator.sub(15, 3);
        System.out.println(sub);

        int mul = calculator.mul(3, 5);
        System.out.println(mul);

        int div = calculator.div(16, 4);
        System.out.println(div);
    }

    @Test
    public void testProxy() {
        // 创建计算器对象
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();

        // 获取代理对象
//        ArithmeticCalculatorLoggingProxy arithmeticCalculatorLoggingProxy = new ArithmeticCalculatorLoggingProxy(calculator);
//        ArithmeticCalculator proxy = arithmeticCalculatorLoggingProxy.getProxy();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(calculator).getProxy();

        int add = proxy.add(150, 150);
        System.out.println(add);


        int sub = proxy.sub(15, 3);
        System.out.println(sub);

        int mul = proxy.mul(3, 5);
        System.out.println(mul);

//        int div = proxy.div(16, 0);
        int div = proxy.div(16, 1);
        System.out.println(div);
    }
}
