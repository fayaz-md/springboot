class A extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
class B extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
		}
	}
}
public class TryException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		B b=new B();
		a.start();
		b.start();
	}

}
