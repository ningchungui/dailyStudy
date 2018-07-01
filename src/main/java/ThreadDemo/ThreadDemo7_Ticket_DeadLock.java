package ThreadDemo;
/*
同步的另一个弊端：
容易引发死锁。

开发时，尽量避免同步嵌套的情况。


*/

class Ticket3 implements Runnable
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
				synchronized(obj)
				{
					sale();
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
		synchronized(obj)
		{
			if(num>0)
			{
				try{Thread.sleep(10);}catch(InterruptedException e){}
				System.out.println(Thread.currentThread().getName()+"..sale:"+num--);
			}
		}
	}
}

class ThreadDemo7_Ticket_DeadLock
{
	public static void main(String[] args) 
	{
		Ticket3 t = new Ticket3();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(InterruptedException e){}
		t.flag = false;
		t2.start();
	}
}

