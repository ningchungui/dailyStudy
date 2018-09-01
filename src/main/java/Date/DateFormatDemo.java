package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		
		Date date = new Date();
		/*
		 * 想要对日期对象的字符串表现形式进行指定格式的显示。
		 * 找到了DateFormat类。
		 * 格式化：日期-->文本  ，日期对象--->字符串。 String format(date)
		 * 解析：文本-->日期，日期格式的字符串-->日期对象。Date parse(String);
		 */
		
		//DateFormat虽然是抽象类，但是该类有提供静态工厂方法(用于获取日期格式实例的方法)。
		DateFormat dateFormat = DateFormat.getDateInstance();//2013-3-25
//		System.out.println(dateFormat);//java.text.SimpleDateFormat@ef7951d7
		
		dateFormat = DateFormat.getDateInstance(DateFormat.FULL);//指定Full格式。2013年3月25日 星期一
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);//指定Long格式。2013年3月25日
		dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);//指定MEDIUM格式。2013-3-25 默认格式。
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);//指定SHORT格式。13-3-25
		
		
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
		//2013年3月25日 星期一 上午11时42分14秒 CST
		
		
		
		//如何通过自定义的格式进行格式化？需要自己创建SimpleDateFormat对象。
		//通过其构造函数将自定义的模式进行对象封装。
		
		dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");//2013/03/25 11:49:33
		
		
		
		//通过format方法对日期对象进行格式化。
		String str_date = dateFormat.format(date);
		System.out.println(str_date);
		
		
		
		
		
		//对日期格式字符串进行解析。
		String str_Date2 = "2011年8月5日";
		DateFormat dateFormat2 =DateFormat.getDateInstance(DateFormat.LONG);
		Date date2 = dateFormat2.parse(str_Date2);
		
		System.out.println(date2);

		/*
		Date d =new Date();
		syetem.out.println(d);//打印的时间看不懂，希望有些格式

		//将模式封装到SimpleDateformat对象中
		SimpleDateformat sdf=new SimpleDateformat("yyyy年MM月dd日E hh:mm:ss");
		//调用format方法让模式格式化指定date对象

		string time =sdf。format(d);

		system.out.println("time="+time);
		
		
		*/



	}

}
