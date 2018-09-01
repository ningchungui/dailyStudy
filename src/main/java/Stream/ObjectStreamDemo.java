package Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.itcast.bean.Person;

public class ObjectStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		
//		writeObj();
		
		readObj();
	}

	public static void readObj() throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("temp\\obj.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		Person p = (Person)obj;
		System.out.println(p.getName()+":"+p.getAge());
		
		ois.close();
		
	}

	public static void writeObj() throws IOException {
		
		/*
		 * 对象的序列化  ObjectOutputStream
		 * 将内存中的对象写到目的设备上。比如硬盘。
		 */
		FileOutputStream fos = new FileOutputStream("temp\\obj.object");		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new Person("mazi",23));
		
		oos.close();
		
		
		
		
		
		
		
		
		
	}

}
