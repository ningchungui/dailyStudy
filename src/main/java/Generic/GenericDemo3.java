package Generic;

public class GenericDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Demo3<String> d3 = new Demo3<String>();
		d3.show("abc");
//		d3.print("haha");
		d3.method("abcde");
		d3.method(new Integer(56));
		
		Demo3<Integer> d33 = new Demo3<Integer>();
		d33.print(8);
//		d33.show("hehe");
		d33.method("hehe");
		
		
		
	}

}
/*
 * 类中操作的对象类型不确定，将泛型定义在类上。
 * 方法中操作的类型不确定，将泛型定义在方法上。
 * 
 * 如果是在静态方法上使用泛型，该泛型必须定义在方法上。
 */

class Demo3<W>{
	
	public void show(W w){
		System.out.println("show :"+w);
	}
	
	public void print(W w){
		System.out.println("print:"+w);
	}
	/*
	 * 将泛型定义在方法上。
	 */
	public <M> void method(M m){
		System.out.println("method:"+m);
	}
	
	public static <K> void function(K w){
		System.out.println("function:"+w);
	}
	
}