package Runtime;

import java.io.IOException;

public class RuntimeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Runtime类，没有构造函数，说明不可以new对象，那么会直接想到该类中的方法都是静态的
		 但是还提供了非静态的方法。说明该类肯定会提供方法获取本类对象，而且该方法是静态的，并返回值类型是本类类型
		 该方式是static Runtime getRuntime();
		
		有这个特点可以看出该类使用了单例设计模式完成


		 * 所以应该会提供静态的返回值类型为Runtime的方法获取该对象。
		 */
		
		//获取Runtime对象。 
		Runtime r = Runtime.getRuntime();
		
		//调用exec执行一个程序。
		Process p = r.exec("notepad.exe E:\\JAVASE0228_SH\\day01\\Demo.java");
		
//		Thread.sleep(4000);
//		p.destroy();
	}

}
