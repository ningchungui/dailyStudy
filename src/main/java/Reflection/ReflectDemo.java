package Reflection;

import cn.itcast.bean.Person;



public class ReflectDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		
		/*
		 * 
		 * 反射机制：对一个类进行动态的获取并创建对象，并调用该类中的内容。
		 * 
		 * 获取字节码文件对象的方式。
		 * 
		 * 方式一：
		 * 使用Object类中的getClass方法。
		 * 该方式必须先创建未知类的对象，在调用getClass方法。
		 * 
		 * 方式二：
		 * 使用静态的class属性就可以获取。
		 * 该方式还是需要使用未知的类。
		 * 
		 * 方式三：
		 * 通过Class类中的静态方法 forName(className)完成;
		 * 爽！只要通过类名就可以获取到对应的字节码文件对象。
		 * 这种方式的扩展性是最好的。
		 * 
		 */
		getClassDemo_3();

		
	}
	
	//方式三
	public static void getClassDemo_3() throws ClassNotFoundException{
		
		
		String className = "cn.itcast.bean.Person";
		
		/*
		 * forName:
		 * 1，根据传入的类的名称，自动去classPath路径下去找寻与该名称相同的类文件。
		 * 2，通过类加载器将该类进行加载，并在内存中生成该类的字节码文件对象。
		 */
		Class clazz = Class.forName(className);
		
		System.out.println(clazz);
		
	}
	
	
	
	//方式二。
	public static void getClassDemo_2() {
		
		Class clazz = Person.class;	
		
		
		Class clazz1 = int.class;
		
	}
	//方式一。
	public static void getClassDemo_1(){
		
		
		Person p1 = new Person();
		Person p2 = new Person();
		
		Class clazz1 = p1.getClass();
		Class clazz2 = p2.getClass();
		
		System.out.println(clazz1 == clazz2);
		
	}
	

}
