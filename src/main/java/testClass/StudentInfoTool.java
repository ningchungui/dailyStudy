package testClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudentInfoTool {

	/**
	 * 定义一个功能，获取键盘录入信息，并将信息封装到学生对象中。把学生存储到集合中。
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	
	public static Set<Student> getStudents() throws NumberFormatException,
	IOException {
		return getStudents(null);
	}

	public static Set<Student> getStudents(Comparator<Student> comp) throws NumberFormatException,
			IOException {
		System.out.println("请输入学生信息，格式：姓名,数学成绩,英语成绩,语文成绩");
		// 1，定义一个集合。
		Set<Student> set = null;
		if(comp == null)//如果没有比较器就选择按照默认排序的顺序来
			set = new TreeSet<Student>();
		else//按照指定顺序进行排序
			set = new TreeSet<Student>(comp);

		// 2，获取键盘录入。
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		String line = null;
		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line))
				break;

			// name,ma,en,cn;
			String[] arr = line.split(",");
			Student stu = new Student(arr[0], Integer.parseInt(arr[1]),
					Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));

			// 将学生对象添加到集合中。
			set.add(stu);
		}
		return set;

	}

	/**
	 * 定义个方法将集合中的学生信息，写入到一个文件中。
	 * 
	 * @throws IOException
	 */
	public static void write2File(Set<Student> set, File destFile)
			throws IOException {

		// 1，创建输出流。
		BufferedWriter bufw = null;

		try {
			bufw = new BufferedWriter(new FileWriter(destFile));

			// 2,遍历集合。
			for (Student stu : set) {

				bufw.write(stu.getName() + ":" + stu.getSum());
				bufw.newLine();
				bufw.flush();
			}
		} finally {
			if (bufw != null)
				try {

					bufw.close();
				} catch (Exception e) {
					throw new RuntimeException("关闭失败");
				}
		}

	}
}
