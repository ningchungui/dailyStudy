package Date;

import java.util.Calendar;

public class CalendarDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 演示日历。Calendar
		 * 
		 * java.util.GregorianCalendar[time=1364193332890,areFieldsSet=true,
		 * areAllFieldsSet=true,lenient=true,
		 * zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,
		 * dstSavings=0,useDaylight=false,transitions=19,lastRule=null],
		 * firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
		 * YEAR=2013,MONTH=2,WEEK_OF_YEAR=13,WEEK_OF_MONTH=5,
		 * DAY_OF_MONTH=25,DAY_OF_YEAR=84,DAY_OF_WEEK=2,
		 * DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=35,
		 * SECOND=32,MILLISECOND=890,ZONE_OFFSET=28800000,DST_OFFSET=0]
		 */

		Calendar c = Calendar.getInstance();
		// System.out.println(c);//说明C是一个对象
		// show(c);

		// 设置具体一天的日期。
		// c.set(2012,3, 5);
		// c.add(Calendar.MONTH, -9);

		// 练习：某一年的二月有多少天。
		int year = 2013;
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		show(c);

	}

	public static void show(Calendar c) {

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		String str_week = getWeek(week);

		System.out.println(year + "年" + month + "月" + day + "日星期" + str_week);
	}

	private static String getWeek(int num) {
		String[] weeks = { "", "日", "一", "二", "三", "四", "五", "六" };

		return weeks[num];
	}
}
