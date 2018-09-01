package Generic;

public class GenericDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1,
		Demo d = new Demo();
		d.show("haha");
		
		
		//2
		Demo2<String> d2 = new Demo2<String>();
		d2.show("haha");
	}

}

/*
 * 泛型接口。
 */

interface Inter<U>{
	public void show(U u);
}

class Demo2<T> implements Inter<T>{

	@Override
	public void show(T u) {
	}
	
}



class Demo implements Inter<String>{

	@Override
	public void show(String u) {
	}
}






