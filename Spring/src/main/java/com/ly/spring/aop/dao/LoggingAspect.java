package com.ly.spring.aop.dao;

import java.util.Arrays;

import javafx.scene.shape.VLineTo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.stereotype.Component;

@Component //交给IOC容器来管理
@Aspect //声明一个类是切面类
public class LoggingAspect {

	//声明切入点表达式
	@Pointcut(value="execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))")
	public void pointCut() {
	}

	/*
	 * 切入点表达式的表示方式：
	 *
	 * 1.execution(public int com.ly.spring.aop.dao.ArithmeticCalculator.add(int, int))
	 * 		-只有执行ArithmeticCalculator中的add方法时才会执行通知
	 * 2.execution(public int com.ly.spring.aop.dao.ArithmeticCalculator.*(int, int))
	 * 		-只有执行ArithmeticCalculator中的所有方法时才会执行通知
	 * 3.execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(int, int))
	 * 		-只有执行ArithmeticCalculator中的所有方法时才会执行通知而且不考虑权限修饰符和返回值类型
	 * 4.execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))
	 * 		-只有执行ArithmeticCalculator中的所有方法时才会执行通知而且不考虑权限修饰符和返回值类型以及参数的类型和个数
	 * 5.execution(* *.*(..))
	 * 		-执行所有类中的所有方法时都会执行通知而且不考虑权限修饰符和返回值类型以及参数的类型和个数
	 */

	//前置通知，在方法执行之前执行
//	@Before(value = "execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))")
	@Before("pointCut()")
	public void beforeLogging(JoinPoint joinPoint) {
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();

		// 获取参数
		Object[] methodArgs = joinPoint.getArgs();

		System.out.println("[Logging]The method " + methodName + " begins with " + Arrays.asList(methodArgs));
	}

	//后置通知，在方法执行之后执行，不管是否发生异常
//	@After("execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))")
	@After("pointCut()")
	public void afterLogging(JoinPoint joinPoint) {
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();

		System.out.println("[Logging]The method " + methodName + " ends");
	}

	//返回通知，在方法执行完成之后执行
//	@AfterReturning(pointcut = "execution(* com.ly.spring.aop.dao.ArithmeticCalculator .*(..))",returning = "result")
	@AfterReturning(value = "pointCut()",returning = "result")
	public void returnLogging(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[Logging]The method " + methodName + " returns " + result);
	}

	//异常通知，在方法执行发生异常时执行
//	@AfterThrowing(pointcut = "execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))", throwing = "e")
	@AfterThrowing(value = "pointCut()",throwing = "e")
	public void throwLogging(JoinPoint jp, Exception e) {
		//获取方法名
		String methodName = jp.getSignature().getName();
		System.out.println("[★Logging]The method " + methodName + " occurs " + e);
	}

	//环绕通知，相当于动态代理的全过程
//	@Around(value = "execution(* com.ly.spring.aop.dao.ArithmeticCalculator .*(..))")
	@Around("pointCut()")
	public Object aroundLogging(ProceedingJoinPoint proceedingJoinPoint) {

		String methodName = proceedingJoinPoint.getSignature().getName();

		Object[] methodArgs = proceedingJoinPoint.getArgs();

		// 方法执行的结果
		Object result = null;

		try {
			// 前置通知
			System.out.println("[☆Logging]The method " + methodName + " begins with " + Arrays.asList(methodArgs));

			// 执行方法
			result = proceedingJoinPoint.proceed();

			// 返回通知
			System.out.println("[☆Logging]The method " + methodName + " returns " + result);
		} catch (Throwable throwable) {
			// 异常通知
			System.out.println("[☆Logging]The method " + methodName + " occurs " + throwable);
		}finally {
			// 后置通知
			System.out.println("[☆Logging]The method " + methodName + " ends");
		}

		return result;
	}

}
