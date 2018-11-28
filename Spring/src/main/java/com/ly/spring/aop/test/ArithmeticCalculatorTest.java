package com.ly.spring.aop.test;

import com.ly.spring.aop.dao.ArithmeticCalculator;
import com.ly.spring.aop.dao.ArithmeticCalculatorImpl;
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
        // 创建计算器对象
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl(); //  多态
        // +
        int add = calculator.add(150, 150);
        System.out.println(add);
        // -
        int sub = calculator.sub(186, 14);
        System.out.println(sub);
        // *
        int mul = calculator.mul(15, 14);
        System.out.println(mul);
        // /
        int div = calculator.div(15, 3);
        System.out.println(div);
    }
}
