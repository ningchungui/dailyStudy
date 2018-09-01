package Reflection;

import java.lang.reflect.Field;

public class ReflectFieldDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws RuntimeException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws Exception {

		
		getFieldDemo();
		
	}

	/*
	 * 反射字段。
	 */
	
	public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
		
		String className = "cn.itcast.bean.Person";
		/*
		 * 获取指定类中的指定名称的字段。
		 * 思路：
		 * 1，通过类名获取字节码文件对象。
		 * 2，通过字节码文件对象获取其中的成员字段。
		 */
		
		//1，获取字节码文件对象。
		Class clazz = Class.forName(className);
		
		//2,通过Class对象的方法获取字段。
//		Field field = clazz.getField("age");//该方法只能访问公有的。
		Field field = clazz.getDeclaredField("age");//可以访问已声明的字段。包括私有。
		
//		System.out.println(field);
		
//		Person p = new Person();
//		p.age = 20;
//		System.out.println(p.age);
		
		//要想对指定属性进行值的设置。必须要先有指定类的对象。
		//对象如何创建呢？没法儿new啊？对象都来自于字节码文件。已经有了字节码文件，获取其对象还远吗？不远！
		Object obj = clazz.newInstance();
		
		
		//取消权限检查。
		field.setAccessible(true);//暴力访问。
		
		//对字段进行值的设置，需要使用字段对象来完成。
		field.set(obj, 30);
		
		System.out.println(field.get(obj));
		
		
		
		
		
		
		
//		System.out.println(clazz.getName());
	}
}
