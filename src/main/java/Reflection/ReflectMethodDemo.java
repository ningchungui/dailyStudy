package Reflection;

import java.lang.reflect.Method;

import cn.itcast.bean.Person;

public class ReflectMethodDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		getMethodDemo3();
		
		
	}
	/*
	 * 获取公有静态的空参数函数。
	 */
	
	public static void getMethodDemo3() throws Exception{
		String className = "cn.itcast.bean.Person";
		Class clazz = Class.forName(className);
		
		Method method = clazz.getMethod("show3", null);
		
		method.invoke(null, null);
		
	}
	
	/*
	 * 获取公有，带参数的函数。
	 */
	
	public static void getMethodDemo2() throws Exception{
		String className = "cn.itcast.bean.Person";
		Class clazz = Class.forName(className);
		
		
		Method method = clazz.getMethod("show2", String.class,int.class);
		
		Object obj = clazz.newInstance();
		
		method.invoke(obj, "wangwu",32);
		
	}
	
	/*
	 * 获取方法。获取公有，空参数的函数。
	 */
	
	public static void getMethodDemo() throws Exception{
		
		
		String className = "cn.itcast.bean.Person";
		Class clazz = Class.forName(className);
		
		//获取指定类中的指定方法。
		
		Method method = clazz.getMethod("show", null);
		
//		System.out.println(method);
		
		/*
		 * 让方法运行起来。
		 */
//		Person p = new Person();
//		p.show();
		
		//获取指定类的对象。
		Object obj = clazz.newInstance();
		
		//调用方法对象的invoke方法。
		method.invoke(obj,null);
		
		
		
	}

}
