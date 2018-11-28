package com.ly.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getProxy() {
		ClassLoader loader = target.getClass().getClassLoader();

		Class<?>[] interfaces = target.getClass().getInterfaces();

		InvocationHandler h = new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();

				Object result = null;

				try {
					System.out.println("[☆Logging]The method " + methodName + "begins with " + Arrays.asList(args));

					result = method.invoke(target, args);

					System.out.println("[☆Logging]The method " + methodName + "return " + result);

				} catch (Exception e) {
					System.out.println("[☆Logging]The method " + methodName + "occurs " + e);
				} finally {
					System.out.println("[☆Logging]The method " + methodName + "ends");
				}

				return result;
			}
		};

		ArithmeticCalculator proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}

//	//声明被代理的对象
//	private ArithmeticCalculator target;
//
//	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
//		this.target = target;
//	}
//
//	public ArithmeticCalculator getProxy() {
//		//获取被代理对象的类加载器
//		ClassLoader loader = target.getClass().getClassLoader();
//		//获取被代理对象实现的接口数组
//		Class<?>[] interfaces = target.getClass().getInterfaces();
//		//调用目标方式时需要执行的代码
//		InvocationHandler h = new InvocationHandler() {
//
//			/*
//			 * proxy：正在返回的代理对象，在invoke方法中一般不使用它
//			 * method：正在调用的方法
//			 * args：调用方法时传入的参数
//			 */
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				//获取方法名
//				String methodName = method.getName();
//				Object result = null;
//				try {
//					//开始日志
//					System.out.println("[☆Logging]The method "+methodName+" begins with "+Arrays.asList(args));
//					//调用目标方法
//					result = method.invoke(target, args);
//					//返回日志
//					System.out.println("[☆Logging]The method "+methodName+" returns " + result);
//				} catch (Exception e) {
//					//异常日志
////					e.printStackTrace();
//					System.out.println("[☆Logging]The method "+methodName+" occurs " + e);
//				} finally {
//					//结束日志
//					System.out.println("[☆Logging]The method "+methodName+" ends ");
//				}
//				return result;
//			}
//		};
//
//		ArithmeticCalculator proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
//		return proxy;
//	}
}
