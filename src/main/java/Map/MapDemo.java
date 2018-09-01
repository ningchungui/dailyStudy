package Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Map集合。
		 * 1，Map集合中存储的是一对儿元素。键和值。之间存在着对应关系。
		 * 2，必须要保证键的唯一性。
		 * 3，如果存储键相同，值会覆盖。
		 */
		
		/*
		 * 需求：将学号和对应的学生姓名进行存储。
		 */
		Map<Integer,String> map = new HashMap<Integer,String>();
		//存储键值对。
		System.out.println(map.put(2,"小花"));
		System.out.println(map.put(2,"麻子"));
		map.put(6,"赵六");
		map.put(1,"王五");
		map.put(1,"王五1");
		
		System.out.println(map);
		
		System.out.println(map.get(1));
		
	}
	
}
