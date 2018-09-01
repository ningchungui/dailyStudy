package Date;

import java.util.Date;

public class DateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Date:
		 */
		//创建一个日期对象。
		Date date = new Date();
		
		System.out.println(date);//Mon Mar 25 11:11:19 CST 2013
		
		long time = System.currentTimeMillis();
		System.out.println(time);//1364181181171
		
		/*
		 * 日期对象和毫秒值之间的转换。
		 * 毫秒值转成-->日期对象。
		 * 1,new Date(long);构造函数形式。
		 * 2，setTime(long):
		 * 获取日期对象，可以通过对象的方法对该日期进行指定字段的操作。
		 */
		date.setTime(1364181181171l);
		
		System.out.println(date);
		
		
		/*
		 * 日期对象转成毫秒值。
		 * 通常用于进行运算。
		 * 通过Date对象的getTime方法。
		 * 
		 */
		
		System.out.println(date.getTime());
	}

}
