package Collection;

import java.util.Arrays;

public class Test2 {
    /**
     * Collection：
     * 	|--List
     * 	|--Set
     *
     *
     *
     * List：
     * 1，是有序的,存入的顺序和取出的顺序一致。
     * 2，元素是有索引的。
     * 3，元素可以重复。
     *
     * 了解List接口的特有方法，注意：这些特有方法都是围绕着角标定义的。
     * 1,add(index,element);
     *
     * 2,remove(index):
     *
     * 3,set(index,element);
     *
     * 4,get(index);
     *
     * List接口支持，增删改查操作。
     *
     * List
     * 	|--Vector:数组结构的,是同步的。被ArrayList替代，因为效率低。
     *
     * 	|--ArrayList:数据结构是数组结构，是不同步的。查询速度很快。
     *
     * 	|--LinkedList:数据结构是链表结构，是不同步的。增删速度很快。
     *
     *
     *
     * --------------------
     *
     * Set:元素不可以重复的。不保证顺序。
     * 	爽了，Set中的方法和Collection中的一致。所以不用在演示了。
     *
     * 	Set:
     * 		|--HashSet:哈希表结构。不同步的。查询速度快。
     * 		|--TreeSet:它可以对Set集合中的元素进行排序。数据结构是二叉树。不同步的。
     * 					TreeSet排序有两种方式：
     * 					第一种：让元素自身具备比较性。让元素对象实现Comparable接口，覆盖compareTo方法。
     * 					但是，需求中，需要元素的非自然排序时，或者元素本身就不具备自然排序时，怎么办？
     * 					第二种：让容器具备比较性。其实就是定义一个比较器，就是实现Comparator接口，
     * 					覆盖compare方法。
     *
     *
     * List集合判断元素是否相同使用的equals方法。
     * HashSet集合判断元素相同，依据 hashCode和equals方法。，
     * TreeSet集合判断元素形同，依据compareTo或者compare方法的return 0;
     *
     *
     * 集合名称规律：
     * 前缀名：数据结构名。
     * 后缀名：所属集合的名字。
     *
     * ArrayList：数组结构，所属于List。想到索引，查询快。
     *
     * LinkedList：链表结构，所属于List。想到增删快。
     *
     * HashSet：哈希表结构，所属于Set,想到唯一性，查询速度快。
     *
     * TreeSet：二叉树结构，所属于Set，想到唯一性，而且排序。
     * 		排序两种，自然排序Comaprable，compareTo比较器排序。Comparator.compare
     *
     */

	private static final String SPACE = " ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str_num = "23 100 -4 8 0 54";
		
		str_num = sortNumbers(str_num);
		
		System.out.println(str_num);
		
		
		
	}
	
//	8，对"23 100 -4 8 0 54"中的数值进行从小打到的排序，并转成字符串。
	/*思路：
	 * 1，排序我懂，需要数组。 
	 * 2，数组在哪里？元素都在字符串里。
	 * 3，咋获取元素？找字符串对象的方法。 String[] string  将字符串按照自定的内容进行切割。
	 * 4，将字符串数组转成int数组。
	 * 5，对int排序。
	 * 6，将排序后的int数组转成字符串。*/
	
	public static String sortNumbers(String str){
		
		//1，将字符串按照给定的规则(空格)进行切割。切成很多字符串。
		String[] arr = getStringArray(str);
		
		//2，将字符串转成int数组。
		int[] nums = parseIntArray(arr);
		
		//3，对int数组排序。
		mySort(nums);
		
		//4，将int数组转成字符串。
		
		String temp = toString(nums);
		
		
		return temp;
	}

	/**
	 * 将int数组转成字符串。
	 * @param nums
	 * @return
	 */
	private static String toString(int[] nums) {
		
		//1，创建一个字符串缓冲区 。
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < nums.length; i++) {
			if(i!=nums.length-1)
				sb.append(nums[i]+" ");
			else
				sb.append(nums[i]);
		}
		
		return sb.toString();
	}

	/**
	 * 对int数组排序。从小到大。
	 * @param nums
	 */
	private static void mySort(int[] nums) {
		Arrays.sort(nums);
	}

	/**
	 * 将字符串数组转成int数组。
	 * @param arr
	 * @return
	 */
	private static int[] parseIntArray(String[] arr) {
		
		//1，创建一个int数组，长度和字符串数组一致。
		int[] nums = new int[arr.length];
		
		//2,遍历字符串数组。将数字格式的字符串转成int数值存储到nums中。
		for (int i = 0; i < arr.length; i++) {
			//将字符串转成int。
			nums[i] = Integer.parseInt(arr[i]);
		}
		
		return nums;
	}

	/**
	 * 将字符串按照指定的规则切割成字符串数组。
	 * @param str
	 * @return
	 */
	private static String[] getStringArray(String str) {
		
		String[] arr = str.split(SPACE);
		return arr;
	}
	

}
