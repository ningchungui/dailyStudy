package File;

public class DiGuiDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*
		 * 递归：函数自身调用自身。功能在内部又进行复用。下次功能使用到了上次功能的运算内容。
		 * 注意：
		 * 1，一定要定义条件。
		 * 2，要控制递归的次数。
		 */
//		show();
		
		int sum = getSum(90000);
		System.out.println(sum);
	}
	
	public static int getSum(int num){
		
		if(num==1)
			return 1;
		
		return num + getSum(num-1);
	}
	
	/*
	public static void show(){
		
		show();
		
	}
	
	public static void method(){
		function();
	}
	
	public static void function(){
		method();
	}
	*/

}
