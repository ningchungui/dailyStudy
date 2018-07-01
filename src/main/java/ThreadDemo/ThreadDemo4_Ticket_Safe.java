package ThreadDemo;
/*
线程安全问题。
原因：

1，多个线程在同时处理共享数据。
2，线程任务中的有多条代码在操作共享数据。

安全问题成因就是：一个线程在通过多条操作共享数据的过程中，其他线程参与了共享数据的操作。
				导致到了数据的错误。


想要知道你的多线程程序有没有安全问题：
只要看线程任务中是否有多条代码在处理共享数据。


解决：
一个线程在通过多条语句操作共享数据的过程中，不允许其他线程参与运算。就哦了。

如何代码体现呢？
Java中提供了同步代码块进行引起安全问题的代码封装。

格式：
synchronized(对象)
{
	//需要被同步的代码；
}


同步：
	好处：解决了多线程的安全问题。
	弊端：降低了效率。每次都要判断锁，较为消耗资源

同步的前提：
	1，至少有两个线程在同步中。
	2，必须保证同步使用的是同一个锁。


*/


class Ticket implements Runnable
{
	private int num = 100;
	Object obj = new Object();
	public void run()
	{
		while(true)
		{
			synchronized(obj)
			{
				if(num>0)
				{
					try{Thread.sleep(10);}catch(InterruptedException e){}//让线程在这里小睡，导致了 0 -1 等错误票的产生。
	//				出现了线程安全问题。
					System.out.println(Thread.currentThread().getName()+"..sale:"+num--);
				}
			}
		}
	}
}

class ThreadDemo4_Ticket_Safe
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

