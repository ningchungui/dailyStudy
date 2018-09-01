package testClass;

//import java.nio.file.CopyOption;

public class Student implements Comparable<Student> {

	private String name;
	private int ma,en,cn;
	private int sum;
	public Student() {
		super();
	}
	public Student(String name, int ma, int en, int cn) {
		super();
		this.name = name;
		this.ma = ma;
		this.en = en;
		this.cn = cn;
		this.sum = ma+en+cn;
	}
	
	
	
	@Override
	public int hashCode() {
		final int NUM = 24;
		return name.hashCode()+sum*NUM;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Student)){
			throw new ClassCastException("类型错误");
		}
		Student stu = (Student)obj;
		return this.name.equals(stu.name) && this.sum == stu.sum;
	}
	//@Override
	public int compareTo(Student o) {
		
		int temp = this.sum - o.sum;
		
		return temp==0?this.name.compareTo(o.name):temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Student [sum=" + sum + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public int getEn() {
		return en;
	}
	public void setEn(int en) {
		this.en = en;
	}
	public int getCn() {
		return cn;
	}
	public void setCn(int cn) {
		this.cn = cn;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
}
