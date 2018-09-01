package Reflection;

import java.lang.reflect.Constructor;

public class ReflectConstructDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		getConstructorDemo();
	}
	
	/*
	 * 反射构造函数。
	 */
	public static void getConstructorDemo() throws ClassNotFoundException, NoSuchMethodException, Exception{
		
		String className = "cn.itcast.bean.Person";
		Class clazz = Class.forName(className);
		
		//之前是通过newInstance进行指定的类的实例化。但是该类中如果没有空参数构造函数呢？
		//或者想通过指定的构造函数进行该类的对象实例化呢？咋办？
		/*
		 * 1，必须先要获取指定的构造函数。
		 * 2，通过获取到的构造函数对对象进行初始化。
		 */
//		Person p = new Person("lisi",20);
		//1,如何获取构造函数呢？通过Class对象。
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//2,如何初始化，构造器最清楚。
		Object obj = constructor.newInstance("lisi",20);
		
		
		
		
	}

}
