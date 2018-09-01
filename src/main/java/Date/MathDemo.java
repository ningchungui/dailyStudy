package Date;

import java.util.Random;

public class MathDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Math：用于数学运算的类。提供了数学运算的静态方法。
		 * 
		 */
		
		double d1 = Math.ceil(12.55);//返回大于参数的最小整数。
		double d2 = Math.floor(12.55);//返回小于参数的最大整数
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		
		double d3 = Math.round(12.55);//四舍五入。
		System.out.println("d3="+d3);
		
		System.out.println(Math.pow(10,3));
		System.out.println("--------------------------");
		//演示随机数。
		Random r = new Random();
		for(int x=0; x<10; x++){
//			double d = (int)(Math.random()*6+1);//Math.ceil(Math.random()*6);
//			double d = r.nextDouble();
			int d = r.nextInt(6)+1;
			System.out.println(d);
		}
		
	}

}
