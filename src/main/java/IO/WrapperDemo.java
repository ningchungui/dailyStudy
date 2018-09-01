package IO;

public class WrapperDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person p = new Person();
//		NewPerson p = new NewPerson();
		NewPerson pp = new NewPerson(p);
		pp.chifan();
		
		/*
		 * 装饰模式：为了解决给类的功能进行增强而出现的。
		 * 
		 * Writer
		 * 		|--TextWriter
		 * 		|--MediaWriter
		 * 
		 * 想要对流对象的功能进行增强，比如提高写入的效率。
		 * 使用缓冲技术。
		 * Writer
		 * 		|--TextWriter
		 * 				|--BufferedTextWriter
		 * 		|--MediaWriter
		 * 				|--BufferedMediaWriter
		 * 
		 * 每一个子类这样实现是可以的，但是导致继承体系较为臃肿。
		 * 发现其实无论哪个子类需要高效，使用的都是缓冲技术。
		 * 干脆将缓冲技术进行单独的描述和封装。
		 * 要缓冲区谁，就将谁传给缓冲区。
		 * BufferdWriter
		 * 
		 * class BufferedWriter extends Writer
		 * {
		 * 		BufferedWriter(Writer w)
		 * 		{}
		 * }
		 * 
		 * 装饰设计模式。
		 * Writer
		 * 		|--TextWriter
		 * 		|--MediaWriter
		 * 		|--BufferedWriter
		 * 
		 * 装饰类和被装饰的特点：
		 * 1，装饰类中的构造函数需要接受被装饰类。
		 * 2，装饰类和被装饰类应该所属于同一个体系。
		 * 
		 */
	}

}

class Person{
	void chifan(){
		System.out.println("吃饭");
	}
}

class NewPerson{
	
	private Person p ;
	NewPerson(Person p){
		this.p = p;
	}
	
	public void chifan(){
		
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
		System.out.println("来一根");
		
	}
}




/*
class NewPerson extends Person{

	@Override
	void chifan() {
		
		System.out.println("开胃酒");
		super.chifan();
		System.out.println("甜点");
		System.out.println("来一根");
		
	}
	
	
}

*/




