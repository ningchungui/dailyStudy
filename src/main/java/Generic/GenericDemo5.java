package Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.itcast.bean.Person;
import cn.itcast.bean.Student;
import cn.itcast.bean.Worker;

public class GenericDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 *？叫做通配符。也可以理解为占位符
		 *
		 * 泛型的限定。	
		 * 
		 * ? extends E :接收E类型或者E的子类型。
		 * 
		 * ? super E : 接收E类型或者E的父类型。
		 * 
		 * 	
		 */
		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("lisi1",21));
		al.add(new Person("lisi2",22));
		al.add(new Person("lisi3",23));
		
		show(al);
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.add(new Student("xiaoming1",21));
		al2.add(new Student("xiaoming2",22));
		al2.add(new Student("xiaoming3",23));
//		show(al2);
		
		ArrayList<String> al3 = new ArrayList<String>();
		al3.add("abc1");
		al3.add("abc2");
		al3.add("abc3");
//		show(al3);
		ArrayList<Worker> al4 = new ArrayList<Worker>();
		al4.add(new Worker("dachui1",21));
		al4.add(new Worker("dachui1",22));
		al4.add(new Worker("dachui1",23));
		show(al4);
		
	}
	
	public static void show(Collection<? super Worker> coll){//问号是通配符
		
		for (Iterator<? super Worker> it = coll.iterator(); it.hasNext();) {
			
			System.out.println(it.next());
			
		}
		
	}

}
