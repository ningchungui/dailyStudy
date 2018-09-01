package Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		
		
		
//		String[] arr = new String[3];//先明确类型。
//		arr[0] = new Integer(34);//存储时，如果类型不匹配，就编译报错。
		
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abcd");		//add(Object obj);
		al.add("cba");		//add(Object obj);
		al.add("cba");		//add(Object obj);
//		al.add(5);//自动装箱,一旦指定了具体元素的类型，存储时不匹配，就编译失败。
		
		for(Iterator<String> it = al.iterator(); it.hasNext(); ){
//			Object obj = it.next();
			String s = it.next();
			System.out.println(s.length());
		}
	}

}
