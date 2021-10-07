class C implements Runnable
{
	int avl=1;
	public synchronized void run()
	{
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(avl==1)
		{
			System.out.println(name+" got ticket");
			avl-=1;
		}
	}
}

public class InterfaceException {
	public static void main(String args[]) {
		Runnable a=new C();
		Thread t1=new Thread(a);
		Thread t2=new Thread(a);
		t1.setName("Raj");
		t2.setName("Seeta");
		t1.start();
		t2.start();
	}
}
