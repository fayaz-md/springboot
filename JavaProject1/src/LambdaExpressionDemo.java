interface Ab{
	public int add(int a,int b);
}
public class LambdaExpressionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Ab obj=(int a,int b)->a+b;
			System.out.println(obj.add(13, 20));
	}

}
