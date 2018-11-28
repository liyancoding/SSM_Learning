package com.ly.spring.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	// 前置通知，在方法执行之前执行
	public void beforeLogging(JoinPoint jp) {
		// 获取方法名
		String methodName = jp.getSignature().getName();
		// 获取参数
		Object[] args = jp.getArgs();
		System.out.println("[☆☆Logging]The method " + methodName + " begins with " + Arrays.asList(args));
	}

	// 后置通知，在方法执行之后执行，不管是否发生异常
	public void AfterLogging(JoinPoint jp) {
		// 获取方法名
		String methodName = jp.getSignature().getName();
		// 获取参数
		// Object[] args = jp.getArgs();
		System.out.println("[☆☆Logging]The method " + methodName + " ends");
	}

	// 返回通知，在方法执行完成之后执行
	public void returnLogging(JoinPoint jp, Object result) {
		// 获取方法名
		String methodName = jp.getSignature().getName();
		System.out.println("[☆☆Logging]The method " + methodName + " returns " + result);
	}

	// 异常通知，在方法执行发生异常时执行
	public void throwLogging(JoinPoint jp, Exception e) {
		// 获取方法名
		String methodName = jp.getSignature().getName();
		System.out.println("[☆☆Logging]The method " + methodName + " occurs " + e);
	}

	// 环绕通知，相当于动态代理的全过程
	public Object aroundLogging(ProceedingJoinPoint pjp) {
		// 获取方法名
		String methodName = pjp.getSignature().getName();
		// 获取参数
		Object[] args = pjp.getArgs();
		Object result = null;
		try {
			// 前置通知
			System.out.println("[★★★☆☆Logging]The method " + methodName + " begins with " + Arrays.asList(args));
			// 执行方法
			result = pjp.proceed();
			// 返回通知
			System.out.println("[★★★☆☆Logging]The method " + methodName + " returns " + result);
		} catch (Throwable e) {
			// 异常通知
			// e.printStackTrace();
			System.out.println("[★★★☆☆Logging]The method " + methodName + " occurs " + e);
		} finally {
			// 后置通知
			System.out.println("[★★★☆☆Logging]The method " + methodName + " ends");
		}
		return result;
	}

}
