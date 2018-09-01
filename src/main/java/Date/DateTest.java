package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		/*
		 * 需求：获取2013/3/16 - 2013/5/27共有多少天？
		 * 
		 * 思路：
		 * 1，获取有多少天，需要相减。咋减呢？
		 * 2，需要有具体的数值。数值怎么来？
		 * 3，需要用到毫秒值，需要用到Date对象。
		 * 4，可是给定是字符串。需要将字符串转成Date对象。
		 * 
		 * 字符串-->Date对象-->毫秒值-->相减。
		 * 
		 * 
		 */
		//1,将字符串转成Date对象。
		String str_1 = "2013/3/16";
		String str_2 = "2013/5/29";
		
		//2,创建一个格式器对象。可以对给定的格式进行解析。
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		//3,解析。parse
		Date date_1 = dateFormat.parse(str_1);
		Date date_2 = dateFormat.parse(str_2);
		
		//4,获取毫秒值。
		long time_1 = date_1.getTime();
		long time_2 = date_2.getTime();
		
		//5,相减。
		long time = Math.abs(time_1 - time_2);
		
		//6,获取天数。
		int day = (int)(time/1000/60/60/24);
		
		System.out.println(day);
		
		
		
		
		
		
		
	}

}
