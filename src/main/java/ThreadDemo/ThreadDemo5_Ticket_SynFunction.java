package ThreadDemo;/*
同步的第二种表现形式。

同步函数。


问题：同步函数使用的锁是什么呢？
	同步函数使用的锁，应该是this。


同步函数和同步代码块的区别？
同步函数使用的固定锁this。
同步代码块使用的锁是可以指定的。

*/




class Ticket2 implements Runnable
{
	private int num = 100;
	boolean flag = true;
	Object obj = new Object();
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)
				{
					if(num>0)
					{
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+"..obj:"+num--);
					}
				}
			}
		}
		else
			while(true)
			{			
				this.sale();
			}
	}

	public synchronized/**/ void sale()//同步函数。
	{
		if(num>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"..func:"+num--);
		}
	}
}

class ThreadDemo5_Ticket_SynFunction
{
	public static void main(String[] args) 
	{
		Ticket2 t = new Ticket2();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
//		Thread t3 = new Thread(t);
//		Thread t4 = new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(InterruptedException e){}
		t.flag = false;
		t2.start();
//		t3.start();
//		t4.start();
	}
}

