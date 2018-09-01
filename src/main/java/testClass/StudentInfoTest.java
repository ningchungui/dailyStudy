package testClass;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class StudentInfoTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		/*
		 * 课后练习：
		 * 有五个学生，每个学生有3门课的成绩，定义一种比较直观的文本文件格式，
		 * 输入学生姓名和成绩，输入的格式：name,30,30,30从键盘输入以上数据（包括姓名，三门课成绩），
	   	 * 按总分数从高到低的顺序将学生信息存放在磁盘文件"stu.txt"中。
	   	 * 
	   	 * 思路：
	   	 * 1，学生是一个实体，包含着姓名和年龄，为了便于操作，就可以将这些信息封装到学生对象中。 
	   	 * 对学生进行描述。
	   	 * 2，定义功能获取键盘录入的信息，因为信息有具体的格式，可以从该格式中将具体的每一个部分信息获取出来。
	   	 * 并封装到学生对象中。
	   	 * 3，学生对象有很多，需要容器进行存储。
	   	 * 4，将容器中的学生对象的信息写入到硬盘文件中。
	   	 * 
qq,30,50,90
ww,40,90,10
pp,10,10,10
uu,90,90,90
mm,80,80,80
		 */
		//创建一个比较器。逆转自然顺序。
		Comparator<Student> comp  = Collections.reverseOrder();
		
		//通过工具类获取集合。
		Set<Student> set = StudentInfoTool.getStudents(comp);
		
		
		//将学生信息写入到文件中。
		File destFile = new File("temp\\stuinfo.txt");
		StudentInfoTool.write2File(set, destFile);
		
		
	}

}
