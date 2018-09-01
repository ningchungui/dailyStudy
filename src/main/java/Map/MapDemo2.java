package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 获取Map中的所有键值对。
		 * Map取出所有元素的原理：将map先转成set，在使用迭代器。
		 * 
		 */
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("zhangsan","北京");
		map.put("lisi","上海");
		map.put("wangwu","成都");
		map.put("zhaoliu","广州");
		
//		System.out.println(map);
		/*
		//第一种方式：
		//获取map集合中的键的集合。keySet();
		Set<String> keySet = map.keySet();
		
		//通过set集合获取迭代器。
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()){
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		*/
		
		/*//第二种方式：
		//获取map集合中所有的键值关系集合。entrySet,键值关系的类型是 Map.Entry.
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		//迭代器取出所有的关系对象。
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key+"::::"+value);
		}*/
		
		
		//第三种方式：获取值的集合。values();
		
		Collection<String> values = map.values();
		
		Iterator<String> it = values.iterator();
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
		
		
	}

}
//MyMap.MyEntry
interface MyMap{
	public static interface MyEntry{//内部接口
		
	}
}
class Demo5 implements MyMap.MyEntry{
	
}

/*
Map.entry其实entry也是一个接口，他是map接口中的一个内部接口

*/

