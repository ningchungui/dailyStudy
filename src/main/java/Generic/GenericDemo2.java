package Generic;

public class GenericDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//Person p = new Person();
		 
//		Tool tool = new Tool();
//		tool.setObject("abc");
//		Person pp = (Person)tool.getObject();
//		pp.getName();
		
		
//		Util<Person> u = new Util<Person>();
//		u.setObject("abc");
//		Person ppp = u.getObject();
	}

}

//该工具类只能操作Person。

//有了泛型以后，这个类就可以重新设计了。
class Util<QQ>{//泛型类。较以前避免了强制麻烦，还提高了安全。
	
	private QQ obj;
	public void setObject(QQ obj){
		this.obj = obj;
	}
	public QQ getObject(){
		return obj;
	}
	
}


//可以不可以定义一个操作所有对象的工具类呢？可以，可以使用Object 
class Tool{
	private Object obj;
	public void setObject(Object obj){
		this.obj = obj;
	}
	public Object getObject(){
		return obj;
	}
}
/*
class Tool{
	
	private Person p;
	public void setPerson(Person p){
		this.p = p;
	}
	public Person getPerson(){
		return p;
	}
}
*/

